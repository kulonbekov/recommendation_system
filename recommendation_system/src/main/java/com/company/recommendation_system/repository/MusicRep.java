package com.company.recommendation_system.repository;

import com.company.recommendation_system.models.entities.Music;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MusicRep extends JpaRepository<Music, Long> {

    Music findByName(String name);
    @Query(value = "select * from tb_music where status = 'ACTIVE' and author = :author order by name asc",nativeQuery = true)
    List<Music> findAllByAuthor(String author);
}
