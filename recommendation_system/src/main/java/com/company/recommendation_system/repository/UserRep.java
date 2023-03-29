package com.company.recommendation_system.repository;

import com.company.recommendation_system.models.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRep extends JpaRepository<User, Long> {

    User findByUsername(String name);
}
