package com.m1s.m1sserver.api.group;

import com.m1s.m1sserver.api.group.Party;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PartyRepository extends JpaRepository<Party, Long> {
    Iterable<Party> findAllByRecruit(Boolean recruit);
    Iterable<Party> findAllByInterestIdAndRecruit(Long interest_id, Boolean recruit);

    @Query(value = "SELECT * FROM party WHERE id in (\n" +
            "SELECT party_id FROM party_member WHERE member_id = ?1 AND authority != \"승인대기\"\n" +
            ");", nativeQuery = true)
    Iterable<Party> findAllByUserId(Long user_id);
}
