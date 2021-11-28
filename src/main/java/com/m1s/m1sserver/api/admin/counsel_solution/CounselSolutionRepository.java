package com.m1s.m1sserver.api.admin.counsel_solution;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RequestParam;

public interface CounselSolutionRepository extends JpaRepository<CounselSolution, Long> {
    CounselSolution findByCounselSurveyId(Long counsel_survey_id);
}
