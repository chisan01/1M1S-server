package com.m1s.m1sserver.api.ranking;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/ranking")
public class RankingController {
    @Autowired
    private RankingRepository rankingRepository;

    @GetMapping
    public Long getRanking(@RequestParam Long user_id, @RequestParam Long interest_id) {
        return rankingRepository.getRank(user_id, interest_id);
    }

    // put은 나중에 admin에서 관리
//    @PutMapping
//    public void setRanking() {
//        Iterable<Ranking> rs = rankingRepository.findAll();
//        for(Ranking s : rs) {
//            s.setScore(0);
//            rankingRepository.save(s);
//        }
//    }
}
