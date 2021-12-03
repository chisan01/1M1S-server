package com.m1s.m1sserver.api.interest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/interest")
public class InterestController {
    @Autowired
    private InterestService interestService;

    @GetMapping("/{interest_id}")
    public Interest getInterest(@PathVariable Long interest_id){
        return interestService.getInterest(interest_id);
    }

    @GetMapping
    public Iterable<Interest> getInterests() {
        return interestService.getInterests();
    }


}
