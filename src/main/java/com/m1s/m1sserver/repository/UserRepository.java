package com.m1s.m1sserver.repository;

import com.m1s.m1sserver.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {
}
