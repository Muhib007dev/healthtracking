package com.healthmonitor.application.utility;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

@Component
public class JwtTokenUtil {
    private static final String SECRET_KEY = "hmafdalkjfdklaenrlsdnlkvskljffndklfakldsnfkdsjkfjlhflksnfjdsflkdsfljfhlsknfljdsfdslkfndsjkfbdslfjdslkfdslkfndsjlfnflkcxvnljkvnkjbnfjdsbfljjflkbfdsnfkanlf";
//    private static final long EXPIRATION_TIME = 3600000; // 1 hour

    public static String generateToken(String username, String password) {
//        Date expirationDate = new Date(System.currentTimeMillis() + EXPIRATION_TIME);
        Key key = Keys.hmacShaKeyFor(SECRET_KEY.getBytes());

        return Jwts.builder()
                .setSubject(username)
                .claim("password", password)
//                .setExpiration(expirationDate)
                .signWith(key)
                .compact();
    }

    public static void processToken(String token) {
        Key key = Keys.hmacShaKeyFor(SECRET_KEY.getBytes());

        Jws<Claims> claimsJws = Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token);

        Claims claims = claimsJws.getBody();
        // Access the claims and perform necessary actions
        String username = claims.getSubject();
        String password = (String) claims.get("password");
        // ... Perform authentication or authorization based on the claims
    }
}
