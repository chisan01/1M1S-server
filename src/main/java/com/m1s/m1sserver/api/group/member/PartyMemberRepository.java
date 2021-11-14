package com.m1s.m1sserver.api.group.member;

import com.m1s.m1sserver.api.group.member.PartyMember;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PartyMemberRepository extends JpaRepository<PartyMember, Long> {
}
