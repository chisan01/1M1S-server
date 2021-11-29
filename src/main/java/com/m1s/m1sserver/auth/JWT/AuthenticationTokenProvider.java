package com.m1s.m1sserver.auth.JWT;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;

import javax.crypto.SecretKey;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

public interface AuthenticationTokenProvider {
    HashMap<String, String> parseTokenString(HttpServletRequest request);
    AuthenticationToken issue(Long user_id);
    Long getTokenOwnerNo(String token);
    Jws<Claims> parseToken(String token, SecretKey PRIVATE_KEY);
}
