package com.SecurityJwt.ExampleJwt.Jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.Map;
import java.util.function.Function;

@Service
public class JwtService {

    private static final String SECRET_KEY="586E3272357538782F413F4428472B4B6250655368566B597033733676397924";


    //Construccion del token
    public String getToken(Map<String,Object> extraClaims, UserDetails user){
        return Jwts
                .builder()
                .setClaims(extraClaims)
                .setSubject(user.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis()+1000*60*24))
                .signWith(getKey(), SignatureAlgorithm.HS256)
                .compact();

    }


    //Generacion de la clave
    private Key getKey(){
        byte[] KeyBytes = Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(KeyBytes);
    }


    public String getUsernameFromToken(String token){
        return ge
    }



    //metodo para extraer la fechas de vencimiento
    public <T> T getClaim(String token, Function<Claims,T> claimsResolver){

        final Claims claims = getAllClaims(token);
        return claimsResolver.apply(claims);

    }




}
