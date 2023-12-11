package com.example.terceranotaweb.jwt;

import com.example.terceranotaweb.entities.UsuarioPrincipal;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.security.SignatureException;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Component
public class JwtProvider {
    private final static Logger logger = LoggerFactory.getLogger(JwtProvider.class);

    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.expiration}")
    private int expiration;

    Set<String> jwtActive = new HashSet<>();

    public String generateToken(Authentication authentication) {
        UsuarioPrincipal usuarioPrincipal = (UsuarioPrincipal) authentication.getPrincipal();
        String token = Jwts.builder().setSubject(usuarioPrincipal.getUsername())
                .setIs
        @Component
        public class JwtProvider {
            private final static Logger logger = LoggerFactory.getLogger(JwtProvider.class);

            @Value("${jwt.secret}")
            private String secret;

            @Value("${jwt.expiration}")
            private int expiration;

            Set<String> jwtActive = new HashSet<>();

            public String generateToken(Authentication authentication) {
                UsuarioPrincipal usuarioPrincipal = (UsuarioPrincipal) authentication.getPrincipal();
                String token = Jwts.builder().setSubject(usuarioPrincipal.getUsername())
                        .setIssuedAt(new Date())
                        .setExpiration(new Date(new Date().getTime() + expiration * 1000))
                        .signWith(SignatureAlgorithm.HS512, secret)
                        .compact();
                jwtActive.add(token);
                return token;
            }

            public void removeToken(String token) {
                jwtActive.remove(token);
            }

            public boolean isTokenValid(String token) {
                return jwtActive.contains(token);
            }

            public String getNombreUsuarioFromToken(String token) {
                return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody().getSubject();
            }

            public boolean validateToken(String token) {
                try {
                    Jwts.parser().setSigningKey(secret).parseClaimsJws(token);
                    return true;
                } catch (MalformedJwtException e) {
                    logger.error("token mal formado");
                } catch (UnsupportedJwtException e) {
                    logger.error("token no soportado");
                } catch (ExpiredJwtException e) {
                    logger.error("token expirado");
                } catch (IllegalArgumentException e) {
                    logger.error("token vacío");
                } catch (SignatureException e) {
                    logger.error("fail en la firma");
                }
                return false;
            }
        }

