package com.company.recommendation_system.services;

import com.company.recommendation_system.models.dtos.UserDto;
import com.company.recommendation_system.models.entities.User;

import java.util.List;

public interface UserService {

    UserDto register (UserDto userDto);
    List<User> getAll();
    User findByUsername(String username);
    User findById(Long id);
    void delete(Long id);
}
