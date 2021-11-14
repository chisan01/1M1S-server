package com.m1s.m1sserver.api.admin;

import com.m1s.m1sserver.api.admin.Environment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnvironmentRepository extends JpaRepository<Environment, Long> {
}
