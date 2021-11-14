package com.m1s.m1sserver.api.user.interest;

import com.m1s.m1sserver.api.admin.interest.InterestRepository;
import com.m1s.m1sserver.api.user.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/user/{user_id}/interest")
public class MemberInterestController {
    @Autowired
    private MemberInterestRepository memberInterestRepository;
    @Autowired
    private InterestRepository interestRepository;
    @Autowired
    private MemberRepository memberRepository;

    @PostMapping
    public @ResponseBody MemberInterest addMemberInterest(@PathVariable long user_id, @RequestParam long interest_id, @RequestParam Integer level) {
        MemberInterest m = new MemberInterest();
        m.setMember(memberRepository.findById(user_id).get());
        m.setInterest(interestRepository.findById(interest_id).get());
        m.setLevel(level);
        memberInterestRepository.save(m);
        return m;
    }

    @GetMapping
    public @ResponseBody Iterable<MemberInterest> getMemberInterests(@PathVariable long user_id) {
        return memberInterestRepository.findAllByMemberId(user_id);
    }

    @PutMapping("/{member_interest_id}")
    public @ResponseBody MemberInterest editMemberInterest(@PathVariable long member_interest_id, @RequestParam Integer level) {
        MemberInterest m = memberInterestRepository.findById(member_interest_id).get();
        if(level != null) m.setLevel(level);
        memberInterestRepository.save(m);
        return m;
    }

    @DeleteMapping("/{member_interest_id}")
    public @ResponseBody MemberInterest delMemberInterest(@PathVariable long member_interest_id) {
        MemberInterest m = memberInterestRepository.findById(member_interest_id).get();
        memberInterestRepository.deleteById(member_interest_id);
        return m;
    }
}
