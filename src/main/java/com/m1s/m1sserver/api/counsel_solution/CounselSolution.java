package com.m1s.m1sserver.api.counsel_solution;

import com.m1s.m1sserver.api.counsel_survey.CounselSurvey;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
public class CounselSolution {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter @Setter
    private long id;

    @OneToOne
    @JoinColumn(name = "counsel_survey_id")
    @Setter @Getter
    private CounselSurvey counselSurvey;

    @Setter @Getter
    private String solution;
}
