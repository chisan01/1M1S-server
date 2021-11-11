package com.m1s.m1sserver.Model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
public class PartyMember {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter @Setter
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "party_id")
    @Getter @Setter
    private Party party;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @Getter @Setter
    private User user;

    @Getter @Setter
    private Integer authority;
}
