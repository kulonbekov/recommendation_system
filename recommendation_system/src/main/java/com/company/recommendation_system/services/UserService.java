package com.company.recommendation_system.services;

import com.company.recommendation_system.models.dtos.UserDto;
import com.company.recommendation_system.models.dtos.resetPassword.ChangePasswordDto;
import com.company.recommendation_system.models.dtos.resetPassword.ResetPasswordDto;
import com.company.recommendation_system.models.entities.ResetPassword;
import com.company.recommendation_system.models.entities.User;

import java.util.List;

public interface UserService {

    UserDto register (UserDto userDto);
    List<User> getAll();
    User findByUsername(String username);
    User findByEmail(String email);
    User findById(Long id);
    void delete(Long id);
    void resetPassword (ResetPasswordDto resetPasswordDto);
    void changePassword(ChangePasswordDto changePasswordDto);
    void send(String to, String subject, String text);
}
