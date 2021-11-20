package com.m1s.m1sserver.api.curriculum.schedule;

import com.m1s.m1sserver.api.admin.curriculum.schedule.CurriculumSchedule;
import com.m1s.m1sserver.api.admin.curriculum.schedule.CurriculumScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/curriculum/{curriculum_id}/schedule")
public class CurriculumScheduleController {
    @Autowired
    private CurriculumScheduleRepository curriculumScheduleRepository;

    @GetMapping
    public Iterable<CurriculumSchedule> getCurriculumSchedule(@PathVariable Long curriculum_id) {
        return curriculumScheduleRepository.findAllByCurriculumId(curriculum_id);
    }
}