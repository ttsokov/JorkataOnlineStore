package org.georgi.shop.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class JWTAuthorizationFilter extends BasicAuthenticationFilter {

    public JWTAuthorizationFilter(AuthenticationManager authenticationManager) {
        super(authenticationManager);
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain chain) throws IOException, ServletException {

        String authorizationHeader = request.getHeader(TokenConstants.AUTHORIZATION_HEADER);

        if (authorizationHeader == null ||
                !authorizationHeader.startsWith(TokenConstants.BEARER)) {
            chain.doFilter(request, response);
        }

        SecurityContextHolder.getContext().setAuthentication(getAuthenticationToken(request));

        chain.doFilter(request, response);
    }

    private UsernamePasswordAuthenticationToken getAuthenticationToken(HttpServletRequest request) {

        String jwtToken = request.getHeader(TokenConstants.AUTHORIZATION_HEADER);

        if (jwtToken != null) {
            String user = JWT.require(Algorithm.HMAC512(TokenConstants.SECRET))
                    .build()
                    .verify(jwtToken.replace(TokenConstants.BEARER, ""))
                    .getSubject();

            if (user != null) {
                return new UsernamePasswordAuthenticationToken(user, null, new ArrayList<>());
            }
        }

        return null;
    }
}
