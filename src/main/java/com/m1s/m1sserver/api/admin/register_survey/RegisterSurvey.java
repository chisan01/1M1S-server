package com.m1s.m1sserver.api.admin.register_survey;

import com.m1s.m1sserver.api.admin.interest.Interest;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
public class RegisterSurvey {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter @Setter
    private Long id;

    @ManyToOne
    @JoinColumn(name = "interest_id")
    @Setter @Getter
    private Interest interest;

    @Setter @Getter
    @JoinColumn(name = "problem_number")
    private Integer problemNumber;

    @Setter @Getter
    private String question;

    @Setter @Getter
    private String choices;
}
