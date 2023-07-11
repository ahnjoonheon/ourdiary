package com.example.ourdiary.admin.configuration.jwt;

import com.example.ourdiary.admin.configuration.jwt.vo.JwtToken;
import com.example.ourdiary.exception.JwtAuthenticationException;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Date;

@Service
public class JwtTokenProvider {

    @Value("${ourdiary.jwt.secret-key}")
    private String secretKey;

    @Value("${ourdiary.jwt.token-validity-in-milliseconds}")
    private long validityInMilliseconds;

    private final UserDetailsService userDetailsService;
    private final MessageSourceAccessor messageSource;

    public JwtTokenProvider(UserDetailsService userDetailsService, MessageSourceAccessor messageSource) {
        this.userDetailsService = userDetailsService;
        this.messageSource = messageSource;
    }

    public Authentication getAuthentication(JwtToken jwtToken) {
        UserDetails userDetails = userDetailsService.loadUserByUsername(getUsername(jwtToken));
        return new UsernamePasswordAuthenticationToken(userDetails, "",userDetails.getAuthorities());
    }

    public JwtToken generateToken(String email, Collection<? extends GrantedAuthority> authorities) {
        Claims claims = Jwts.claims().setSubject(email);
        claims.put("authorities", authorities.stream().map(Object::toString).toList());
        Date now = new Date();
        Date validity = new Date(now.getTime() + validityInMilliseconds);
        return new JwtToken(Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(now)
                .setExpiration(validity)
                .signWith(SignatureAlgorithm.HS256, secretKey)
                .compact());
    }

    public String getUsername(JwtToken jwtToken) {
        try {
            return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(jwtToken.stringify()).getBody().getSubject();
        } catch (Exception e) {
            throw new JwtAuthenticationException(messageSource.getMessage("exception.jwt.invalid-token"));
        }
    }

    public JwtToken resolveToken(HttpServletRequest request) {
        JwtToken jwtToken = new JwtToken(request.getHeader("Authorization"));
        if(jwtToken.hasBearerPrefix()) {
            return jwtToken.removeBearerPrefix();
        }
        return null;
    }

    public boolean validateToken(JwtToken jwtToken) {
        try {
            Jws<Claims> claimsJws = Jwts.parser().setSigningKey(secretKey).parseClaimsJws(jwtToken.stringify());
            return !claimsJws.getBody().getExpiration().before(new Date());
        } catch (Exception e) {
            throw new JwtAuthenticationException(messageSource.getMessage("exception.jwt.invalid-token"));
        }
    }
}
