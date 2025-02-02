package com.m1s.m1sserver.api.admin.enviroment;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EnvironmentRepository extends JpaRepository<Environment, Long> {
    Environment findByName(String name);
}
