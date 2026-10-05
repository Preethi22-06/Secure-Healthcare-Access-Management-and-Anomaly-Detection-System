package com.preethi.securehealthcare.repository;

import com.preethi.securehealthcare.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}