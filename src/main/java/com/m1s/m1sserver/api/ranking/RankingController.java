package com.m1s.m1sserver.api.ranking;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/ranking")
public class RankingController {
    @Autowired
    private RankingRepository rankingRepository;

    @GetMapping
    public long getRanking(@RequestParam long user_id, @RequestParam long interest_id) {
        return rankingRepository.getRank(user_id, interest_id);
    }

    @PutMapping
    public void setRanking() {
        Iterable<Ranking> rs = rankingRepository.findAll();
        for(Ranking s : rs) {
            s.setScore(0);
            rankingRepository.save(s);
        }
    }
}
