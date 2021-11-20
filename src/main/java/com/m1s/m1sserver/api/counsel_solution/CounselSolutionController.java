package com.m1s.m1sserver.api.counsel_solution;

import com.m1s.m1sserver.api.admin.counsel_solution.CounselSolution;
import com.m1s.m1sserver.api.admin.counsel_solution.CounselSolutionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/counsel-solution")
public class CounselSolutionController {
    @Autowired
    private CounselSolutionRepository counselSolutionRepository;

    @GetMapping
    public Iterable<CounselSolution> getCounselSolution() {
        return counselSolutionRepository.findAll();
    }
}
