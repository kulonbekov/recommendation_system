package com.company.recommendation_system.services.impl;

import com.company.recommendation_system.mappers.UserMapper;
import com.company.recommendation_system.models.dtos.UserDto;
import com.company.recommendation_system.models.entities.Role;
import com.company.recommendation_system.models.entities.User;
import com.company.recommendation_system.models.enums.Status;
import com.company.recommendation_system.repository.RoleRep;
import com.company.recommendation_system.repository.UserRep;
import com.company.recommendation_system.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRep userRep;
    private final RoleRep roleRep;
    private final PasswordEncoder passwordEncoder;
    UserMapper userMapper = UserMapper.INSTANCE;
    @Override
    public UserDto register(UserDto userDto) {

        return userMapper.toDto(userRep.save(toEntity(userDto)));
    }

    @Override
    public List<User> getAll() {
        List<User> result = userRep.findAll();
        return result;
    }

    @Override
    public User findByUsername(String username) {
        User result = userRep.findByUsername(username);
        return result;
    }

    @Override
    public User findById(Long id) {
        User result = userRep.findById(id).orElseThrow(() -> new RuntimeException("User is not found"));
        return result;
    }

    @Override
    public void delete(Long id) {
        userRep.deleteById(id);
    }

    private User toEntity(UserDto userDto){
        Role roleUser = roleRep.findByName("ROLE_USER");
        List<Role> userRoles = new ArrayList<>();
        userRoles.add(roleUser);

        User user = new User();
        user.setUsername(userDto.getUsername());
        user.setEmail(userDto.getEmail());
        user.setGender(userDto.getGender());
        user.setAge(userDto.getAge());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        user.setRoles(userRoles);
        user.setStatus(Status.ACTIVE);

        return user;
    }
}
