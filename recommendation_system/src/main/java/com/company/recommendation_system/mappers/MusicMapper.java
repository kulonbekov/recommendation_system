package com.company.recommendation_system.mappers;

import com.company.recommendation_system.models.dtos.MusicDto;
import com.company.recommendation_system.models.entities.Music;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MusicMapper extends BaseMapper<Music, MusicDto> {

    MusicMapper INSTANCE = Mappers.getMapper(MusicMapper.class);

}
