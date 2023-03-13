package eng.cpe.se.project.security.jwt;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.config.web.server.ServerHttpSecurity.OAuth2ResourceServerSpec.JwtSpec;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import eng.cpe.se.project.security.service.UserDetailsImpl;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;

@Component
public class JwtUtils {
	
	private static final Logger logger = LoggerFactory.getLogger(JwtUtils.class);
	
	@Value("${jwt.signing.key}")
	private String SIGNING_KEY;
	
	@Value("${jwt.token.validity}")
	private int TOKEN_VALIDITY;
	
	public String generateToken(Authentication authentication) {
		UserDetailsImpl userPrincipal = (UserDetailsImpl) authentication.getPrincipal();
		
		return Jwts.builder()
				.setSubject((userPrincipal.getEmail()))
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + TOKEN_VALIDITY * 1000))
				.signWith(SignatureAlgorithm.HS256, SIGNING_KEY)
				.compact();
	}
	
	public String getUserNameFromJwtToken(String token) {
		return Jwts.parser().setSigningKey(SIGNING_KEY).parseClaimsJws(token).getBody().getSubject();
	}
	
	public boolean validationJwtToken(String authToken) {
		try {
			Jwts.parser().setSigningKey(SIGNING_KEY).parse(authToken);
			return true;
		}catch (SignatureException e) {
			logger.error("Invalid JWT signature: {}",e.getMessage());
		}catch (MalformedJwtException e) {
			logger.error("Invalid JWT Token:{}",e.getMessage());
		}catch (ExpiredJwtException e) {
			logger.error("JWT Token is expired:{}",e.getMessage());
		}catch (UnsupportedJwtException e) {
			logger.error("JWT Token is unsupported:{}",e.getMessage());
		}catch (IllegalArgumentException e) {
			logger.error("JWT claims string is empty:{}",e.getMessage());
		}
		return false;
	}

}
