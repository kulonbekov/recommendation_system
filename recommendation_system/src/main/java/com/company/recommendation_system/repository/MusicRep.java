package com.company.recommendation_system.repository;

import com.company.recommendation_system.models.entities.Music;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MusicRep extends JpaRepository<Music, Long> {
}
