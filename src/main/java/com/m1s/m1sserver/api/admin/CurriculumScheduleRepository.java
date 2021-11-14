package com.m1s.m1sserver.api.admin;

import com.m1s.m1sserver.api.admin.CurriculumSchedule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CurriculumScheduleRepository extends JpaRepository<CurriculumSchedule, Long> {
}
