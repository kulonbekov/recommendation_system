package com.company.recommendation_system.repository;

import com.company.recommendation_system.models.entities.ResetPassword;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResetPasswordRep extends JpaRepository<ResetPassword, Long> {
}
