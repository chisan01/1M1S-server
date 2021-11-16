package com.m1s.m1sserver.api.register_survey;

import com.m1s.m1sserver.api.admin.interest.Interest;
import com.m1s.m1sserver.api.admin.register_survey.RegisterSurvey;
import com.m1s.m1sserver.api.admin.register_survey.RegisterSurveyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/register-survey")
public class RegisterSurveyController {
    @Autowired
    private RegisterSurveyRepository registerSurveyRepository;

    @GetMapping
    public Iterable<RegisterSurvey> getRegisterSurvey(@RequestParam long interest_id) {
        return registerSurveyRepository.findAllByInterestId(interest_id, Sort.by("problemNumber"));
    }
}
