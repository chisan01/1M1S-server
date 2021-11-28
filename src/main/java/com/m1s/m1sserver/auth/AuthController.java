package com.m1s.m1sserver.auth;


import com.m1s.m1sserver.UserStorage;
import com.m1s.m1sserver.api.user.information.MemberInformation;
import com.m1s.m1sserver.api.user.information.MemberInformationService;
import com.m1s.m1sserver.api.user.interest.MemberInterest;
import com.m1s.m1sserver.api.user.interest.MemberInterestService;
import com.m1s.m1sserver.auth.JWT.AuthenticationToken;
import com.m1s.m1sserver.auth.member.Member;
import com.m1s.m1sserver.auth.member.MemberService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private AuthService authService;

    @Autowired
    private MemberInterestService memberInterestService;

    @Autowired
    private MemberInformationService memberInformationService;

    @Autowired
    private MemberService memberService;

    @PostMapping("/join")
    public MemberInformation join(@RequestBody MemberInformation memberInformation){
        return authService.join(memberInformation);
    }

    @PostMapping("/survey-result")
    public @ResponseBody
    MemberInterest addMemberInterest(@RequestBody MemberInterest memberInterest) {
        return memberInterestService.createMemberInterest(memberInterest);
    }

    @DeleteMapping("/me")
    public void deleteAccount(Authentication authentication){
        Member me = authService.getMe(authentication);
        authService.deleteAccount(me);
    }

    @DeleteMapping("rollback")
    public void rollBackJoin(@RequestBody MemberInformation memberInformation){
        Member member = memberInformation.getMember();
        memberInformationService.deleteMemberInformation(memberInformation.getMember());
        memberService.deleteMember(member);
    }

    @PostMapping("/login")
    public AuthenticationToken login(@RequestBody Member member){
        return authService.login(member);
    }

    @PostMapping("/logout")
    public boolean logout(Authentication authentication){
        Member me = authService.getMe(authentication);
        return authService.logout(me);
    }

}
