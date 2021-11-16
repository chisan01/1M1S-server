package com.m1s.m1sserver.api.counsel_survey;

import com.m1s.m1sserver.api.admin.counsel_survey.CounselSurvey;
import com.m1s.m1sserver.api.admin.counsel_survey.CounselSurveyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/counsel-survey")
public class CounselSurveyController {
    @Autowired
    private CounselSurveyRepository counselSurveyRepository;

    @GetMapping
    public Iterable<CounselSurvey> getCounselSurvey() {
        return counselSurveyRepository.findAll(Sort.by("problemNumber"));
    }
}
