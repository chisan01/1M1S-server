package com.m1s.m1sserver.api.counsel_solution;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CounselSolutionRepository extends JpaRepository<CounselSolution, Long> {
    CounselSolution findByCounselSurveyId(Long counsel_survey_id);
}
