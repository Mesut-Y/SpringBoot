package com.my.jwt;

import java.security.Key;
import java.util.Date;
import java.util.function.Function;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtService {

	private static final String SECRET_KEY = "VoUs4Gg25Q+XXKHOKYYQ4p3fdJi2BrDReiiuHq4HRhQ=";

	public String generateToken(UserDetails userDetails) {
		return Jwts.builder()
				.setSubject(userDetails.getUsername()) //username would be token's subject
				.setIssuedAt(new Date()) //creating date
				.setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 2)) //1000ms *60*60*2 = 2 hours
				.signWith(getKey(), SignatureAlgorithm.HS256) //HS256 algorithm 
				.compact(); 
	}

	public <T> T exportToken(String token, Function<Claims, T> claimsFunction) {
		Claims claims = Jwts
				.parserBuilder()
				.setSigningKey(getKey())
				.build()
				.parseClaimsJws(token)
				.getBody();

		return claimsFunction.apply(claims);
	}

	public String getUsernameByToken(String token) {
		return exportToken(token, Claims::getSubject);
	}

	public boolean isTokenExpired(String token) {
		Date expiredDate = exportToken(token, Claims::getExpiration);
		return new Date().before(expiredDate); // if current time is less than expiredDate True, else False
	}

	public Key getKey() { //generate key with SECRET_KEY
		byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY); 
		return Keys.hmacShaKeyFor(keyBytes);
	}
}
