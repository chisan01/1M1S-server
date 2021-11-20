package com.m1s.m1sserver.api.user;

import com.m1s.m1sserver.api.user.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
