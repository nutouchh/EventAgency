package com.nutouchh.EventAgency.repositories;

import com.nutouchh.EventAgency.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}