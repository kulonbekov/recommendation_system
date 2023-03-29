package com.company.recommendation_system.mappers;

import com.company.recommendation_system.models.dtos.UserDto;
import com.company.recommendation_system.models.entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper  extends BaseMapper<User, UserDto>{
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
}
