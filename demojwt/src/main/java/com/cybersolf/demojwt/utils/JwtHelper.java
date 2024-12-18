package com.cybersolf.demojwt.utils;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;

@Component
public class JwtHelper  {
    @Value("${jwt.key}")
    private String keyJwt;
    public boolean deccript(String token){
        boolean result = false;
        try {
            SecretKey key = Keys.hmacShaKeyFor(Decoders.BASE64.decode(keyJwt));
            Jwts.parser().verifyWith(key).build().parseSignedClaims(token);
            result = true;
        }catch (Exception e){
            System.out.println("Decryption: "+e.getMessage());
        }
        return result;
    }
    public String getDataToken(String token){
        SecretKey key = Keys.hmacShaKeyFor(Decoders.BASE64.decode(keyJwt));
        String role="";
        try {
            role=Jwts.parser().verifyWith(key).build().parseSignedClaims(token).getPayload().getSubject();
        }catch (Exception e){
            System.out.println("Error Decoding: " + e.getMessage());
        }
        return role;
    }
}
