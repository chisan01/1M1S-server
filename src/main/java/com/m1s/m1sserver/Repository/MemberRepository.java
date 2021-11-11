package com.m1s.m1sserver.Repository;

import com.m1s.m1sserver.Model.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
