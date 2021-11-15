package com.m1s.m1sserver.api.admin.register_survey;

import com.m1s.m1sserver.api.admin.interest.Interest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin/register-survey")
public class RegisterSurveyController {
    @Autowired
    private RegisterSurveyRepository registerSurveyRepository;

    @PostMapping
    public RegisterSurvey addRegisterSurvey(@RequestBody RegisterSurvey r) {
        registerSurveyRepository.save(r);
        return r;
    }

    @GetMapping
    public Iterable<RegisterSurvey> getRegisterSurvey(@RequestParam long interest_id) {
        return registerSurveyRepository.findAllByInterestId(interest_id, Sort.by("problemNumber"));
    }

    @PutMapping("/{register_survey_id}")
    public RegisterSurvey editRegisterSurvey(@PathVariable long register_survey_id, @RequestBody RegisterSurvey r) {
        RegisterSurvey edit = registerSurveyRepository.findById(register_survey_id).get();

        if(r.getInterest() != null) edit.setInterest(r.getInterest());
        if(r.getProblemNumber() != null) edit.setProblemNumber(r.getProblemNumber());
        if(r.getQuestion() != null) edit.setQuestion(r.getQuestion());
        if(r.getChoices() != null) edit.setChoices(r.getChoices());

        registerSurveyRepository.save(edit);
        return edit;
    }

    @DeleteMapping("/{register_survey_id}")
    public RegisterSurvey delRegisterSurvey(@PathVariable long register_survey_id) {
        RegisterSurvey r = registerSurveyRepository.findById(register_survey_id).get();
        registerSurveyRepository.deleteById(register_survey_id);
        return r;
    }
}
