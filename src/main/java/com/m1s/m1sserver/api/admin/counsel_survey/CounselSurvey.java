package com.m1s.m1sserver.api.admin.counsel_survey;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
public class CounselSurvey {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter @Setter
    private Long id;

    @JoinColumn(name = "problem_number")
    @Setter @Getter
    private Integer problemNumber;

    @Setter @Getter
    private String question;

    @Setter @Getter
    private String choices;
}
