package com.m1s.m1sserver.api.admin.curriculum.schedule;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.PathVariable;

public interface CurriculumScheduleRepository extends JpaRepository<CurriculumSchedule, Long> {
    Iterable<CurriculumSchedule> findAllByCurriculumId(Long curriculum_id);
}
