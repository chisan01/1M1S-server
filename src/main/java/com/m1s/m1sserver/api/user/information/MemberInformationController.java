package com.m1s.m1sserver.api.user.information;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@Controller
@RequestMapping("/api/user/{user_id}/information")
public class MemberInformationController {
    @Autowired
    private MemberInformationRepository memberInformationRepository;

    @GetMapping
    public @ResponseBody MemberInformation getMemberInformation(@PathVariable long user_id) {
        return memberInformationRepository.findByMemberId(user_id);
    }

    @PutMapping
    public @ResponseBody MemberInformation editMemberInformation(@PathVariable long user_id, @RequestBody MemberInformation m) {
        MemberInformation edited = memberInformationRepository.findByMemberId(user_id);
        String name = m.getName();
        String nickname = m.getNickname();
        String gender = m.getGender();
        String phone = m.getPhone();
        String email = m.getEmail();
        LocalDateTime register_date = m.getRegister_date();

        if(name != null) edited.setName(name);
        if(nickname != null) edited.setNickname(nickname);
        if(gender != null) edited.setGender(gender);
        if(phone != null) edited.setPhone(phone);
        if(email != null) edited.setEmail(email);
        if(register_date != null) edited.setRegister_date(register_date);

        memberInformationRepository.save(edited);
        return edited;
    }
}
