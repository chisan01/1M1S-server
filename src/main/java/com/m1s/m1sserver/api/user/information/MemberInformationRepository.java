package com.m1s.m1sserver.api.user.information;

import com.m1s.m1sserver.api.user.information.MemberInformation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberInformationRepository extends JpaRepository<MemberInformation, Long> {
    MemberInformation findByMemberId(long user_id);
}
