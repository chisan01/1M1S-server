package com.m1s.m1sserver.auth;

import com.m1s.m1sserver.api.user.information.MemberInformation;
import com.m1s.m1sserver.auth.member.Member;
import lombok.Getter;
import lombok.Setter;

class JoinForm{
    @Getter
    @Setter
    MemberInformation memberInformation;
    @Getter @Setter
    Member member;
}