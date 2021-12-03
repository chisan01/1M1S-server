package com.m1s.m1sserver.api.interest;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface InterestRepository extends JpaRepository<Interest, Long> {
    Boolean existsBySubject(String subject);
    Optional<Interest> findBySubject(String subject);
}
