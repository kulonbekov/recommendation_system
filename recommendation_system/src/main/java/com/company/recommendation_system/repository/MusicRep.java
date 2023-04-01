package com.company.recommendation_system.repository;

import com.company.recommendation_system.models.entities.Music;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MusicRep extends JpaRepository<Music, Long> {

    Music findByName(String name);
    @Query(value = "select * from tb_music where status = 'ACTIVE' and author like %:author% order by name asc",nativeQuery = true)
    List<Music> findAllByAuthor(String author);
    @Query(value = "select *\n" +
            "from tb_music m\n" +
            "join tb_music_genre tmg on m.id = tmg.music_id\n" +
            "join tb_genre tg on tg.id = tmg.genre_id\n" +
            "Where tg.name like %:genre% and m.status = 'ACTIVE'\n" +
            "ORDER BY m.name asc ",nativeQuery = true)
    List<Music> findAllByGenre(String genre);
    @Query(value = "select * from tb_music where status = 'ACTIVE' and name like %:name% order by name asc",nativeQuery = true)
    List<Music> findAllByName(String name);
}
