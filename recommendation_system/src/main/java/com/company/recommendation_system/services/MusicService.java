package com.company.recommendation_system.services;

import com.company.recommendation_system.models.dtos.MusicDto;
import com.company.recommendation_system.models.entities.Music;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface MusicService {

    //ROLE_ADMIN
    MusicDto save(MusicDto musicDto, MultipartFile myImage, MultipartFile mySong);

    //ROLE_USER
    //Filters
    //FindAllByAuthor
    List<MusicDto> findAllByAuthor(String author);

    //Filters
    //FindAllByGenre
    List<MusicDto> findAllByGenre(String genre);

    //Filters
    //FindAllByName
    List<MusicDto> findAllByName(String name);

    //FindByName
    MusicDto findByName(String name);

    //Recommendation
    //Popular
    List<MusicDto> findAllByPopular();

    //Recommendation
    //New
    List<MusicDto> findAllByNew();

    //Delete
    MusicDto delete(Long id);
}
