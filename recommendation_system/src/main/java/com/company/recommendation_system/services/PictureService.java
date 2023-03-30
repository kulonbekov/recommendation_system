package com.company.recommendation_system.services;

import com.company.recommendation_system.models.dtos.PictureDto;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface PictureService {

    PictureDto save(PictureDto pictureDto, MultipartFile file);

    List<PictureDto> findAll();

    PictureDto findById(Long id);

    PictureDto delete(Long id);
}
