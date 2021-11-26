package com.m1s.m1sserver.api.user.counsel_result;

import com.m1s.m1sserver.api.admin.counsel_solution.CounselSolution;
import com.m1s.m1sserver.api.user.Member;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class MemberCounselResult {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter @Setter
    private Long id;

    @ManyToOne
    @JoinColumn(name = "member_id")
    @Setter @Getter
    private Member member;

    @Column(length = 1000)
    @Getter @Setter
    private String counselSolution;

    @JoinColumn(name = "counsel_time")
    @Setter @Getter
    private LocalDateTime counselTime;
}
