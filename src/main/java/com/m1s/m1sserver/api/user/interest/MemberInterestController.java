package com.m1s.m1sserver.api.user.interest;

import com.m1s.m1sserver.api.interest.Interest;
import com.m1s.m1sserver.api.interest.InterestRepository;
import com.m1s.m1sserver.api.interest.InterestService;
import com.m1s.m1sserver.auth.AuthService;
import com.m1s.m1sserver.auth.member.Member;
import com.m1s.m1sserver.auth.member.MemberRepository;
import com.m1s.m1sserver.utils.CustomException;
import com.m1s.m1sserver.utils.ErrorCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user/interest")
public class MemberInterestController {
    @Autowired
    private MemberInterestService memberInterestService;

    @Autowired
    private InterestService interestService;

    @Autowired
    private AuthService authService;

    @PostMapping
    public @ResponseBody
    MemberInterest addMemberInterest(Authentication authentication, @RequestBody MemberInterest memberInterest) {
        System.out.println(memberInterest.getInterest());
        memberInterest.setMember(authService.getMe(authentication));

        if(memberInterest.getInterest() == null)return memberInterest;
        return memberInterestService.createMemberInterest(memberInterest);
    }



    @GetMapping
    public @ResponseBody Iterable<MemberInterest> getMemberInterests(Authentication authentication) {
        Member me = authService.getMe(authentication);
        return memberInterestService.getMemberInterests(me);
    }

    @PutMapping("/{member_interest_id}")
    public @ResponseBody MemberInterest editMemberInterestLevel(Authentication authentication, @PathVariable Long member_interest_id, @RequestParam String level) {
        Member me = authService.getMe(authentication);
        MemberInterest memberInterest = memberInterestService.getMemberInterest(member_interest_id);
        return memberInterestService.editLevel(me, memberInterest, level);
    }

    @DeleteMapping("/{member_interest_id}")
    public @ResponseBody MemberInterest deleteMemberInterest(Authentication authentication, @PathVariable Long member_interest_id) {
        Member me = authService.getMe(authentication);
        MemberInterest memberInterest = memberInterestService.getMemberInterest(member_interest_id);
        memberInterestService.deleteMemberInterest(me, memberInterest);
        return memberInterest;
    }
}
