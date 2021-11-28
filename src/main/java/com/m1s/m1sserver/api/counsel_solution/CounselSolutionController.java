package com.m1s.m1sserver.api.counsel_solution;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/counsel-solution")
public class CounselSolutionController {
    @Autowired
    private CounselSolutionService counselSolutionService;

    @GetMapping("/{counsel_survey_id}")
    public CounselSolution getCounselSolutions(@PathVariable Long counsel_survey_id) {
        return counselSolutionService.getCounselSolution(counsel_survey_id);
    }
}
