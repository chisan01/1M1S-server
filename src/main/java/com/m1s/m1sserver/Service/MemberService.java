package com.m1s.m1sserver.Service;

import com.m1s.m1sserver.api.user.Member;
import com.m1s.m1sserver.api.user.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class MemberService {

    @Autowired
    private MemberRepository memberRepository;

    public Member findById(Long user_id){
        Optional<Member> result = memberRepository.findById(user_id);
        return result.get();
    }



}
