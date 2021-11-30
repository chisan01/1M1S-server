package com.m1s.m1sserver.auth;


import com.m1s.m1sserver.api.group.member.PartyMemberService;
import com.m1s.m1sserver.api.ranking.RankingService;
import com.m1s.m1sserver.api.user.counsel_result.MemberCounselResultService;
import com.m1s.m1sserver.api.user.curriculum.MemberCurriculumService;
import com.m1s.m1sserver.api.user.information.MemberInformation;
import com.m1s.m1sserver.api.user.information.MemberInformationService;
import com.m1s.m1sserver.api.user.interest.MemberInterestService;
import com.m1s.m1sserver.api.user.schedule.MemberScheduleService;
import com.m1s.m1sserver.auth.JWT.AuthenticationToken;
import com.m1s.m1sserver.auth.JWT.JwtAuthentication;
import com.m1s.m1sserver.auth.JWT.JwtAuthenticationTokenProvider;
import com.m1s.m1sserver.auth.member.Member;
import com.m1s.m1sserver.auth.member.MemberService;
import com.m1s.m1sserver.auth.refresh_token.RefreshTokenService;
import com.m1s.m1sserver.utils.CustomException;
import com.m1s.m1sserver.utils.ErrorCode;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    @Autowired
    RefreshTokenService refreshTokenService;

    @Autowired
    MemberService memberService;

    @Autowired
    MemberInformationService memberInformationService;

    @Autowired
    JwtAuthenticationTokenProvider jwtAuthenticationTokenProvider;

    @Autowired
    private RankingService rankingService;

    @Autowired
    private MemberInterestService memberInterestService;

    @Autowired
    private MemberScheduleService memberScheduleService;

    @Autowired
    private MemberCurriculumService memberCurriculumService;

    @Autowired
    private PartyMemberService partyMemberService;

    @Autowired
    private MemberCounselResultService memberCounselResultService;

    @Autowired
    private PasswordEncoder passwordEncoder;
    private Member member;

    public String encodePassword(String password){return passwordEncoder.encode(password);}

    public MemberInformation join(MemberInformation memberInformation){
        memberInformation = memberInformationService.insertMemberInformation(memberInformation);

        return memberInformation;
    }


    public Long getMyId(Authentication authentication){

        JwtAuthentication jwtAuthentication = (JwtAuthentication) authentication;
        System.out.println(jwtAuthentication.getPrincipal().getBody());
        return Long.parseLong(jwtAuthentication.getPrincipal().getBody().getSubject());
    }
    public Member getMe(Authentication authentication){
        return memberService.getMember(getMyId(authentication));
    }
    public AuthenticationToken login(Member member){
        if(member.getUsername().equals(""))throw new CustomException(ErrorCode.NO_USERNAME);
        if(member.getPassword().equals(""))throw new CustomException(ErrorCode.NO_PASSWORD);
        Member foundMember = memberService.loginInformationCheck(member.getUsername(), member.getPassword());

        AuthenticationToken authenticationToken = jwtAuthenticationTokenProvider.issue(memberService.getMember(member.getUsername()).getId());
        //refreshTokenService.insertRefreshToken(member, authenticationToken.getRefreshToken());
        return authenticationToken;
    }

    public void checkOwner(Member user, Member target){
        if(user.getId() == target.getId())return;
    }

    public void checkPassword(Member user, String password){
        if(user.getPassword() != encodePassword(password));
    }
    public boolean logout(Member member){
        return true;
    }

    public void deleteAccount(Member member){
        rankingService.deleteRankings(member);
        memberInterestService.deleteMemberInterests(member);
        memberScheduleService.deleteMemberSchedules(member);
        memberCurriculumService.deleteMemberCurriculums(member);
        partyMemberService.deletePartyMembers(member);
        memberCounselResultService.deleteMemberCounselResults(member);
        memberService.deleteMember(member);
    }
}
