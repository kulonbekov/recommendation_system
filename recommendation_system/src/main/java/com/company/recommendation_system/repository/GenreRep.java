package com.company.recommendation_system.repository;

import com.company.recommendation_system.models.entities.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenreRep extends JpaRepository<Genre, Long> {

    Genre findByName (String name);
}
