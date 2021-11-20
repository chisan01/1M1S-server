package com.m1s.m1sserver.api.user.counsel_result;

import com.m1s.m1sserver.api.user.counsel_result.MemberCounselResult;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.PathVariable;

public interface MemberCounselResultRepository extends JpaRepository<MemberCounselResult, Long> {
    Iterable<MemberCounselResult> findAllByMemberId(Long user_id, Sort sort);
}
