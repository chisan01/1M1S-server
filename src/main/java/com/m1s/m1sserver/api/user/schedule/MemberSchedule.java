package com.m1s.m1sserver.api.user.schedule;

import com.m1s.m1sserver.api.admin.interest.Interest;
import com.m1s.m1sserver.api.user.Member;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class MemberSchedule {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter @Setter
    private long id;

    @ManyToOne
    @JoinColumn(name = "member_id")
    @Getter @Setter
    private Member member;

    @Getter @Setter
    private String content;

    @JoinColumn(name = "start_time")
    @Getter @Setter
    private LocalDateTime startTime;

    @JoinColumn(name = "end_time")
    @Getter @Setter
    private LocalDateTime endTime;

    @Getter @Setter
    private Boolean finish;

    @ManyToOne
    @JoinColumn(name = "interest_id")
    @Getter @Setter
    private Interest interest;
}
