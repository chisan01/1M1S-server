package com.m1s.m1sserver.JWT;

import com.m1s.m1sserver.Interface.AuthenticationToken;
import com.m1s.m1sserver.Interface.AuthenticationTokenProvider;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.security.SignatureException;
import org.dom4j.util.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;

@Component
public class JwtAuthenticationTokenProvider implements AuthenticationTokenProvider {
    private static final Logger logger = LoggerFactory.getLogger(JwtAuthenticationTokenProvider.class);

    @Value("accessPrivateKey")
    private static String ACCESS_PRIVATE_KEY;

    @Value("expirationMS")
    private static long EXPIRATION_MS;

    @Override
    public String parseTokenString(HttpServletRequest request) {
        String bearerToken = request.getHeader("Authorization");
        if (bearerToken != null && bearerToken.startsWith("Bearer ")) return bearerToken.substring(7);
        return null;
    }
    private String buildToken(Integer userId){
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime expiredAt = now.plus(EXPIRATION_MS, ChronoUnit.MILLIS);
        return Jwts.builder()
                .setSubject(String.valueOf(userId))
                .setIssuedAt(Date.from(now.atZone(ZoneId.systemDefault()).toInstant()))
                .setExpiration(Date.from(expiredAt.atZone(ZoneId.systemDefault()).toInstant()))
                .signWith(getSignKey())
                .compact();
    }

    private Key getSignKey(){
        return Keys.hmacShaKeyFor(ACCESS_PRIVATE_KEY.getBytes(StandardCharsets.UTF_8));
    }
    @Override
    public AuthenticationToken issue(Integer user_id){
        return JwtAuthenticationToken.builder().token(buildToken(user_id)).build();
    };

    @Override
    public Integer getTokenOwnerNo(String token){
        Claims claims = Jwts.parserBuilder()
                .setSigningKey(ACCESS_PRIVATE_KEY).build()
                .parseClaimsJws(token).getBody();
        return Integer.parseInt(claims.getSubject());
    };

    @Override
    public boolean validateToken(String token){
        if(!token.isEmpty()){
            try{
                Jwts.parserBuilder().setSigningKey(ACCESS_PRIVATE_KEY).build()
                        .parseClaimsJws(token);
                return true;
            }catch(SignatureException e){//헤더, 페이로드, 시그니쳐 중 시그니쳐가 해석 불가능할 때
                logger.error("Invalid JWT signature", e);
            }catch(MalformedJwtException e){//구조가 불량일 경우
                logger.error("Invalud JWT token", e);
            }catch (ExpiredJwtException e){//만료된 토큰
                logger.error("Expired JWT token", e);
            }catch (UnsupportedJwtException e){
                logger.error("Unsupported JWT Token", e);
            }catch (IllegalArgumentException e){
                logger.error("JWT claims string is empty", e);
            }
        }
        return false;
    };

}
