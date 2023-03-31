package com.company.recommendation_system.mappers;

import com.company.recommendation_system.models.dtos.resetPassword.ResetPasswordDto;
import com.company.recommendation_system.models.entities.ResetPassword;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ResetPasswordMapper extends BaseMapper<ResetPassword, ResetPasswordDto> {

    ResetPasswordMapper INSTANCE = Mappers.getMapper(ResetPasswordMapper.class);
}
