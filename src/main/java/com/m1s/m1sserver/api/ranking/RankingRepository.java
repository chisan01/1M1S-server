package com.m1s.m1sserver.api.ranking;

import com.m1s.m1sserver.api.ranking.Ranking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RankingRepository extends JpaRepository<Ranking, Long> {
}
