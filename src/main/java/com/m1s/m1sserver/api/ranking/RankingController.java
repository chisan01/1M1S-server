package com.m1s.m1sserver.api.ranking;

import com.m1s.m1sserver.api.interest.Interest;
import com.m1s.m1sserver.api.interest.InterestService;
import com.m1s.m1sserver.auth.member.Member;
import com.m1s.m1sserver.auth.member.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/ranking")
public class RankingController {
    @Autowired
    private RankingService rankingService;

    @Autowired
    private MemberService memberService;

    @Autowired
    private InterestService interestService;

    @GetMapping
    public Long getRankNum(@RequestParam Long user_id, @RequestParam Long interest_id) {
        Member member = memberService.getMember(user_id);
        Interest interest = interestService.getInterest(interest_id);
        return rankingService.getRankNum(member, interest);
    }

    @GetMapping("/top3")
    public Iterable<Ranking> getTopRankings(@RequestParam Long interest_id) {
        return rankingService.getTopRankings(interest_id);
    }
}
