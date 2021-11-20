package com.m1s.m1sserver.api.interest;

import com.m1s.m1sserver.api.admin.interest.Interest;
import com.m1s.m1sserver.api.admin.interest.InterestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/interest")
public class InterestController {
    @Autowired
    private InterestRepository interestRepository;

    @GetMapping
    public Iterable<Interest> getInterest() {
        return interestRepository.findAll();
    }
}
