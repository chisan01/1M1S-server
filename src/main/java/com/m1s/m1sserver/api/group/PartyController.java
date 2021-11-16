package com.m1s.m1sserver.api.group;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/group")
public class PartyController {
    @Autowired PartyRepository partyRepository;

    @GetMapping
    public Iterable<Party> getParty(@RequestParam(required = false) Long interest_id) {
        if(interest_id == null) return partyRepository.findAllByRecruit(true);
        else return partyRepository.findAllByInterestIdAndRecruit(interest_id, true);
    }
}
