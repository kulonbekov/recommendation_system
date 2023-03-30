package com.company.recommendation_system.repository;

import com.company.recommendation_system.models.entities.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TagRep extends JpaRepository<Tag, Long> {

    Tag findByName(String name);
}
