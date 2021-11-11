package com.m1s.m1sserver.Interface;

import javax.servlet.http.HttpServletRequest;

import com.m1s.m1sserver.JWT.JwtAuthenticationToken;
public interface AuthenticationTokenProvider {
    String parseTokenString(HttpServletRequest request);
    AuthenticationToken issue(Integer user_id);
    Integer getTokenOwnerNo(String token);
    boolean validateToken(String token);
}
