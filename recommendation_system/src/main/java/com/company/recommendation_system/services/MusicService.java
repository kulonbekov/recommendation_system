package com.company.recommendation_system.services;

import com.company.recommendation_system.models.dtos.MusicDto;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface MusicService {

    //ROLE_ADMIN
    MusicDto save(MusicDto musicDto, MultipartFile myImage, MultipartFile mySong);

    //ROLE_USER
    //Filters
    //FindAllByAuthor
    List<MusicDto> findAllByAuthor(String author);


    //FindByName
    MusicDto findByName(String name);



    //Delete
    MusicDto delete(Long id);
}
