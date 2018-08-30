package org.georgi.shop.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private AuthenticationManager authenticationManager;

    public JWTAuthenticationFilter(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request,
                                                HttpServletResponse response) throws AuthenticationException {

        org.georgi.shop.model.User credentials = null;
        try {
            credentials = new ObjectMapper().readValue(request.getInputStream(), org.georgi.shop.model.User.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return this.authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        Objects.requireNonNull(credentials).getUsername(),
                        credentials.getPassword(),
                        new ArrayList<>()
                )
        );
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request,
                                            HttpServletResponse response,
                                            FilterChain chain, Authentication authResult) throws IOException, ServletException {
        String token = JWT.create()
                        .withSubject(((User) authResult.getPrincipal()).getUsername())
                        .withExpiresAt(new Date(System.currentTimeMillis() + TokenConstants.EXPIRATION_TIME))
                        .sign(Algorithm.HMAC512(TokenConstants.SECRET));

        response.addHeader(TokenConstants.AUTHORIZATION_HEADER, TokenConstants.BEARER + token);
    }
}
