package com.m1s.m1sserver.api.user.information;

import com.m1s.m1sserver.auth.member.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberInformationRepository extends JpaRepository<MemberInformation, Long> {
    MemberInformation findByMember(Member member);
    boolean existsByEmail(String email);
    boolean existsByMember(Member member);

    boolean existsByPhone(String phone);
}
