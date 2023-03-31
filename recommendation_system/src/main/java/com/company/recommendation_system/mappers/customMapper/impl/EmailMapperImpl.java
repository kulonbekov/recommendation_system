package com.company.recommendation_system.mappers.customMapper.impl;

import com.company.recommendation_system.mappers.customMapper.EmailMapper;
import com.company.recommendation_system.models.dtos.resetPassword.ResetPasswordDto;
import org.springframework.stereotype.Service;

@Service
public class EmailMapperImpl implements EmailMapper {
    @Override
    public String toString(ResetPasswordDto dto) {
        String sendText = "Username: " + dto.getUsername() +
                "\n Token: " + dto.getResetToken();
        return sendText;
    }
}
