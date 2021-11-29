package com.m1s.m1sserver.api.register_survey;

import com.m1s.m1sserver.api.user.interest.MemberInterest;
import com.m1s.m1sserver.api.user.interest.MemberInterestService;
import com.m1s.m1sserver.auth.AuthService;
import com.m1s.m1sserver.auth.member.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/register-survey")
public class RegisterSurveyController {
    @Autowired
    private RegisterSurveyService registerSurveyService;

    @Autowired
    private AuthService authService;


    @Autowired
    private MemberInterestService memberInterestService;

    @GetMapping
    public Iterable<RegisterSurvey> getRegisterSurvey(@RequestParam("interest_id") Long interest_id) {
        return registerSurveyService.getRegisterSurveys(interest_id);
    }

    @PostMapping
    public @ResponseBody
    MemberInterest addMemberInterest(Authentication authentication, @RequestBody MemberInterest memberInterest) {
        Member me = authService.getMe(authentication);
        memberInterest.setMember(me);
        return memberInterestService.createMemberInterest(memberInterest);
    }
}
