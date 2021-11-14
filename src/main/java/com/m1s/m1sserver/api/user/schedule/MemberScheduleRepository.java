package com.m1s.m1sserver.api.user.schedule;

import com.m1s.m1sserver.api.user.schedule.MemberSchedule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberScheduleRepository extends JpaRepository<MemberSchedule, Long> {
}
