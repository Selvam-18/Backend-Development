package com.example.SpringSecurity.service;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.security.Key;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
public class JWTService {

    private final String secretKey = "aslkjLKJDIOUjhgKtygjhHKJkngjhFGH98776jhbT7YGU";

    public String generateToken(String username) {

        Map<String, Object> claims = new HashMap<>();

        return Jwts.builder()
                .setClaims(claims)
                .setSubject(username)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 5))
                .signWith(getKey(), SignatureAlgorithm.HS256)
                .compact();

    }

    private Key getKey() {
        byte[] keyBytes = Decoders.BASE64.decode(secretKey);
        return Keys.hmacShaKeyFor(keyBytes);
    }

//    public boolean validateToken(String username, UserDetails userDetails) {
//        return true;
//    }
//
//    public String extractUsername() {
//        return "";
//    }

    public String extractUserName(String token) {
        // extract the username from jwt token
        System.out.println("Extracting username");

        System.out.println("TOKEN=[" + token + "]");
        System.out.println("DOTS=" + token.split("\\.").length);
//        System.out.println(extractClaim(token, Claims::getSubject) + " Check 2");
        return extractClaim(token, Claims::getSubject);
    }

    private <T> T extractClaim(String token, Function<Claims, T> claimResolver) {
        final Claims claims = extractAllClaims(token);
        return claimResolver.apply(claims);
    }

    private Claims extractAllClaims(String token) {
        return Jwts.parser().verifyWith((SecretKey) getKey())
//                .setSigningKey(getKey())
                .build().parseSignedClaims(token).getPayload();
    }


    public boolean validateToken(String token, UserDetails userDetails) {
        System.out.println(token +  "IS this username or token");
        System.out.println("Validating Token");
        System.out.println(token + " --- " + userDetails.getUsername());
        final String userName = extractUserName(token);
        System.out.println("Username" + userName);
        System.out.println(userDetails.getUsername() + "DEmo");
        System.out.println(userName.equals(userDetails.getUsername()) + "Demo");
        System.out.println(!isTokenExpired(token) + "boolean");
        return (userName.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }

    private boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    private Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

}
