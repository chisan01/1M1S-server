package com.m1s.m1sserver.api.group.member;

import com.m1s.m1sserver.api.group.Party;
import com.m1s.m1sserver.auth.member.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PartyMemberRepository extends JpaRepository<PartyMember, Long> {
    PartyMember findByMemberAndParty(Member member, Party group);
    Boolean existsByMemberAndParty(Member member, Party group);
    Iterable<PartyMember> findAllByParty(Party group);
    void deleteAllByParty(Party group);
    void deleteAllByMember(Member member);
}
