package com.m1s.m1sserver.api.user.curriculum;

import com.m1s.m1sserver.api.admin.curriculum.Curriculum;
import com.m1s.m1sserver.api.admin.curriculum.CurriculumRepository;
import com.m1s.m1sserver.api.user.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

@Controller
@RequestMapping("/api/user/{user_id}/curriculum")
public class MemberCurriculumController {
    @Autowired
    private MemberCurriculumRepository memberCurriculumRepository;
    @Autowired
    private MemberRepository memberRepository;
    @Autowired
    private CurriculumRepository curriculumRepository;

    @PostMapping
    public @ResponseBody MemberCurriculum addMemberCurriculum(@PathVariable Long user_id, @RequestParam Long curriculum_id) {
        // 이미 존재하는 경우 예외처리
        if(memberCurriculumRepository.findByMemberIdAndCurriculumId(user_id, curriculum_id) != null) return null;

        MemberCurriculum m = new MemberCurriculum();
        m.setMember(memberRepository.findById(user_id).get());
        m.setCurriculum(curriculumRepository.findById(curriculum_id).get());
        memberCurriculumRepository.save(m);
        return m;
    }

    @GetMapping
    public @ResponseBody Iterable<MemberCurriculum> getMemberCurriculum(@PathVariable Long user_id) {
        return memberCurriculumRepository.findAllByMemberId(user_id);
    }

    @DeleteMapping
    public @ResponseBody MemberCurriculum delMemberCurriculum(@PathVariable Long user_id, @RequestParam Long curriculum_id) {
        MemberCurriculum m = memberCurriculumRepository.findByMemberIdAndCurriculumId(user_id, curriculum_id);
        if(m == null) return null;
        memberCurriculumRepository.deleteById(m.getId());
        return m;
    }
}
