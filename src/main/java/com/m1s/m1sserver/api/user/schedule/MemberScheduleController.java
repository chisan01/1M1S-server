package com.m1s.m1sserver.api.user.schedule;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user/{user_id}/schedule")
public class MemberScheduleController {
    @Autowired
    private MemberScheduleRepository memberScheduleRepository;

    @PostMapping
    public MemberSchedule addMemberSchedule(@PathVariable long user_id, @RequestBody MemberSchedule m) {
        memberScheduleRepository.save(m);
        return m;
    }

    @GetMapping
    public Iterable<MemberSchedule> getMemberSchedule(@PathVariable long user_id) {
        return memberScheduleRepository.findAllByMemberId(user_id, Sort.by("startTime"));
    }

    @PutMapping("/{member_schedule_id}")
    public MemberSchedule editMemberSchedule(@PathVariable long user_id, @PathVariable long member_schedule_id, @RequestBody MemberSchedule m) {
        MemberSchedule edit = memberScheduleRepository.findById(member_schedule_id).get();

        if(m.getContent() != null) edit.setContent(m.getContent());
        if(m.getStartTime() != null) edit.setStartTime(m.getStartTime());
        if(m.getEndTime() != null) edit.setEndTime(m.getEndTime());
        if(m.getFinish() != null) edit.setFinish(m.getFinish());
        if(m.getInterest() != null) edit.setInterest(m.getInterest());

        memberScheduleRepository.save(edit);
        return edit;
    }

    @DeleteMapping("/{member_schedule_id}")
    public MemberSchedule delMemberSchedule(@PathVariable long user_id, @PathVariable long member_schedule_id) {
        MemberSchedule m = memberScheduleRepository.findById(member_schedule_id).get();
        memberScheduleRepository.deleteById(member_schedule_id);
        return m;
    }
}
