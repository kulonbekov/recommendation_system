package com.company.recommendation_system.mappers;

import com.company.recommendation_system.models.dtos.PictureDto;
import com.company.recommendation_system.models.entities.Picture;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
@Mapper
public interface PictureMapper extends BaseMapper<Picture, PictureDto>{
    PictureMapper INSTANCE = Mappers.getMapper(PictureMapper.class);
}
