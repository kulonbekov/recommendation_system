package com.company.recommendation_system.repository;

import com.company.recommendation_system.models.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRep extends JpaRepository<Role, Long> {

    Role findByName(String name);
}
