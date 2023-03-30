package com.company.recommendation_system.services;

import com.company.recommendation_system.models.dtos.PictureDto;
import org.springframework.web.multipart.MultipartFile;

public interface PictureService {

    PictureDto save(PictureDto pictureDto, MultipartFile file);
}
