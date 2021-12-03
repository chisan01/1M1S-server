package com.m1s.m1sserver.api.user.information;


import com.m1s.m1sserver.auth.member.Member;
import com.m1s.m1sserver.auth.member.MemberRepository;
import com.m1s.m1sserver.auth.member.MemberService;
import com.m1s.m1sserver.utils.CustomException;
import com.m1s.m1sserver.utils.ErrorCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class MemberInformationService {
    @Autowired
    MemberInformationRepository memberInformationRepository;
    @Autowired
    MemberService memberService;

    @Autowired
    MemberRepository memberRepository;

    public MemberInformation insertMemberInformation(MemberInformation memberInformation){
        if(memberInformation.getEmail().equals(""))throw new CustomException(ErrorCode.NO_EMAIL);
        if(memberInformation.getNickname().equals(""))throw new CustomException(ErrorCode.NO_NICKNAME);
        if(memberInformation.getName().equals(""))throw new CustomException(ErrorCode.NO_USERNAME);
        if(memberInformationRepository.existsByEmail(memberInformation.getEmail()))
            throw new CustomException(ErrorCode.DUPLICATE_EMAIL);
        if(memberInformationRepository.existsByNickname(memberInformation.getNickname()))
            throw new CustomException(ErrorCode.DUPLICATE_NICKNAME);
        if(memberInformation.getMember().getUsername().equals(""))
            throw new CustomException(ErrorCode.NO_USERNAME);
        if(memberInformation.getMember().getPassword().equals(""))
            throw new CustomException(ErrorCode.NO_PASSWORD);
        if(memberRepository.existsByUsername(memberInformation.getMember().getUsername()))
            throw new CustomException(ErrorCode.DUPLICATE_USERNAME);
        memberInformation.setMember(memberService.insertMember(memberInformation.getMember()));
        memberInformation.setRegister_date(LocalDateTime.now());
        memberInformationRepository.save(memberInformation);
        return memberInformation;
    }

    public boolean checkOwner(Member member, MemberInformation memberInformation){
        if(member.getId() != memberInformation.getMemberId())throw new CustomException(ErrorCode.NO_AUTHENTICATION);
        return true;
    }

    public MemberInformation editMemberInformation(Member member, MemberInformation oldMemberInformation, MemberInformation newMemberInformation){
        checkOwner(member, oldMemberInformation);
        if(newMemberInformation.getName() != null)
            oldMemberInformation.setName
                    (newMemberInformation.getName());
        if(newMemberInformation.getNickname() != null)
            oldMemberInformation.setNickname
                    (newMemberInformation.getNickname());
        if(newMemberInformation.getGender() != null)
            oldMemberInformation.setGender
                    (newMemberInformation.getGender());
        if(newMemberInformation.getPhone() != null)
            oldMemberInformation.setPhone
                    (newMemberInformation.getPhone());
        if(newMemberInformation.getEmail() != null)
            oldMemberInformation.setEmail
                    (newMemberInformation.getEmail());
        return save(oldMemberInformation);
    }

    public MemberInformation save(MemberInformation memberInformation){
        return memberInformationRepository.save(memberInformation);
    }
    public MemberInformation getMemberInfo(Member member){
        if(!memberInformationRepository.existsByMember(member))throw new CustomException(ErrorCode.MEMBER_NOT_FOUND);
        return memberInformationRepository.findByMember(member);
    }

    public void deleteMemberInformation(Member member){
        MemberInformation targetMemberInformation = getMemberInfo(member);
        memberInformationRepository.deleteById(targetMemberInformation.getId());
    }
}
