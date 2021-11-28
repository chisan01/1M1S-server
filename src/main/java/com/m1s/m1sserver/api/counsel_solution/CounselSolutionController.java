package com.m1s.m1sserver.api.counsel_solution;

import com.m1s.m1sserver.api.admin.counsel_solution.CounselSolution;
import com.m1s.m1sserver.api.admin.counsel_solution.CounselSolutionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/counsel-solution")
public class CounselSolutionController {
    @Autowired
    private CounselSolutionRepository counselSolutionRepository;

    @GetMapping("/{counsel_survey_id}")
    public CounselSolution getCounselSolution(@PathVariable Long counsel_survey_id) {
        return counselSolutionRepository.findByCounselSurveyId(counsel_survey_id);
    }
}
