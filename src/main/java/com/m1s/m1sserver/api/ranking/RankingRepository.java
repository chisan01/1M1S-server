package com.m1s.m1sserver.api.ranking;

import com.m1s.m1sserver.api.ranking.Ranking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.RequestParam;

public interface RankingRepository extends JpaRepository<Ranking, Long> {
    @Query(value = "SELECT RANK FROM (\n" +
            "SELECT score, member_id,\n" +
            "DENSE_RANK() over ( ORDER BY score DESC ) as rank\n" +
            "FROM ranking WHERE interest_id = ?2\n" +
            ") AS r WHERE member_id = ?1", nativeQuery = true)
    Long getRank(Long user_id, Long interest_id);

    void deleteAllByMemberId(Long user_id);
    boolean existsByMemberIdAndInterestId(Long user_id, Long interest_id);
    Ranking findByMemberIdAndInterestId(Long user_id, Long interest_id);

    @Query(value = "SELECT id,score,interest_id,member_id FROM (\n" +
            "SELECT *,\n" +
            "DENSE_RANK() over ( ORDER BY score DESC ) as RANK\n" +
            "FROM ranking WHERE interest_id = ?1\n" +
            ") AS r ORDER BY RANK\n" +
            "LIMIT 3", nativeQuery = true)
    Iterable<Ranking> getTopRankings(Long interest_id);
}
