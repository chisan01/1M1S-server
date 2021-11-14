package com.m1s.m1sserver.api.group;

import com.m1s.m1sserver.api.group.Party;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PartyRepository extends JpaRepository<Party, Long> {
}
