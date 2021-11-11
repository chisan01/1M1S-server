package com.m1s.m1sserver.JWT;

import com.m1s.m1sserver.Interface.AuthenticationToken;
import lombok.Builder;
import lombok.Getter;



@Builder
@Getter
public class JwtAuthenticationToken implements AuthenticationToken {
    private String token;
}
