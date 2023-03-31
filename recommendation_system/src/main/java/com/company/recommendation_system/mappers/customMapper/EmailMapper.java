package com.company.recommendation_system.mappers.customMapper;

import com.company.recommendation_system.models.dtos.resetPassword.ResetPasswordDto;
import com.company.recommendation_system.models.entities.ResetPassword;

public interface EmailMapper {
    String toString (ResetPasswordDto resetPasswordDto);
}
