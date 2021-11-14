package com.m1s.m1sserver.api.admin;

import com.m1s.m1sserver.api.admin.Curriculum;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CurriculumRepository extends JpaRepository<Curriculum, Long> {
}
