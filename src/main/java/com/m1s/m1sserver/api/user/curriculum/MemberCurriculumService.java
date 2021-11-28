package com.m1s.m1sserver.api.user.curriculum;


import com.m1s.m1sserver.api.curriculum.Curriculum;
import com.m1s.m1sserver.api.user.counsel_result.MemberCounselResult;
import com.m1s.m1sserver.auth.AuthService;
import com.m1s.m1sserver.auth.member.Member;
import com.m1s.m1sserver.utils.CustomException;
import com.m1s.m1sserver.utils.ErrorCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class MemberCurriculumService {
    @Autowired
    private MemberCurriculumRepository memberCurriculumRepository;

    @Autowired
    private AuthService authService;

    public Boolean checkOwner(Long user_id, MemberCurriculum memberCurriculum){
        return user_id.equals(memberCurriculum.getMemberId());
    }

    public MemberCurriculum createMemberCurriculum(Member member, Curriculum curriculum){
        return MemberCurriculum.builder()
                .member(member)
                .curriculum(curriculum)
                .build();
    }

    public Iterable<MemberCurriculum> getMemberCurriculums(Member member){
        return memberCurriculumRepository.findAllByMember(member);
    }

    public MemberCurriculum getMemberCurriculum(Long member_curriculum_id){
        if(!memberCurriculumRepository.existsById(member_curriculum_id))
            throw new CustomException(ErrorCode.MEMBER_CURRICULUM_NOT_FOUND);
        return memberCurriculumRepository.findById(member_curriculum_id).get();
    }

    public MemberCurriculum getMemberCurriculum(Authentication authentication, Long curriculum_id) {
        return memberCurriculumRepository.findByMemberAndCurriculumId(authService.getMe(authentication), curriculum_id);
    }

    public MemberCurriculum deleteMemberCurriculum(Authentication authentication, Long curriculum_id){
        MemberCurriculum foundMemberCurriculum = getMemberCurriculum(authentication, curriculum_id);
        if(foundMemberCurriculum == null)
            throw new CustomException(ErrorCode.MEMBER_CURRICULUM_NOT_FOUND);
        memberCurriculumRepository.delete(foundMemberCurriculum);
        return foundMemberCurriculum;
    }

    public void deleteMemberCurriculums(Member member){
        memberCurriculumRepository.deleteAllByMember(member);
    }
    public MemberCurriculum save(MemberCurriculum memberCurriculum){
        return memberCurriculumRepository.save(memberCurriculum);
    }
}
