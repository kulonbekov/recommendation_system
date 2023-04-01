package com.company.recommendation_system.services;

import com.company.recommendation_system.models.dtos.MusicDto;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface MusicService {

    MusicDto save(MusicDto musicDto, MultipartFile myImage, MultipartFile mySong);

    List<MusicDto> findAll();

    MusicDto findById(Long id);

    MusicDto delete(Long id);
}
