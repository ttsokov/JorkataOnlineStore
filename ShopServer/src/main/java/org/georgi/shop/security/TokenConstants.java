package org.georgi.shop.security;

public interface TokenConstants {
    String SECRET = "GenerateJWTToken";
    long EXPIRATION_TIME = 432_000_000;
    String BEARER = "Bearer ";
    String AUTHORIZATION_HEADER = "Authorization";
}
