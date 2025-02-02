package com.m1s.m1sserver.api.admin.interest;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
public class Interest {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter @Setter
    private Long id;

    @Getter @Setter
    private String subject;
}
