package com.m1s.m1sserver.api.user.counsel_result;

import com.m1s.m1sserver.auth.member.Member;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberCounselResultRepository extends JpaRepository<MemberCounselResult, Long> {
    Iterable<MemberCounselResult> findAllByMember(Member member, Sort sort);
    MemberCounselResult findByMember(Member member);
    boolean existsById(Long member_counsel_result_id);
    void deleteById(Long member_counsel_result_id);
    void deleteAllByMember(Member member);
}
