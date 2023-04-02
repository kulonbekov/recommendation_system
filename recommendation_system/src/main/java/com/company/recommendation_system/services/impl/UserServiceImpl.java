package com.company.recommendation_system.services.impl;

import com.company.recommendation_system.mappers.ResetPasswordMapper;
import com.company.recommendation_system.mappers.UserMapper;
import com.company.recommendation_system.mappers.customMapper.EmailMapper;
import com.company.recommendation_system.models.dtos.UserDto;
import com.company.recommendation_system.models.dtos.resetPassword.ChangePasswordDto;
import com.company.recommendation_system.models.dtos.resetPassword.ResetPasswordDto;
import com.company.recommendation_system.models.entities.Genre;
import com.company.recommendation_system.models.entities.Role;
import com.company.recommendation_system.models.entities.User;
import com.company.recommendation_system.models.enums.Status;
import com.company.recommendation_system.repository.GenreRep;
import com.company.recommendation_system.repository.ResetPasswordRep;
import com.company.recommendation_system.repository.RoleRep;
import com.company.recommendation_system.repository.UserRep;
import com.company.recommendation_system.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRep userRep;
    private final RoleRep roleRep;
    private final GenreRep genreRep;
    private final PasswordEncoder passwordEncoder;
    private final ResetPasswordRep resetPasswordRep;
    private final EmailMapper emailMapper;
    UserMapper userMapper = UserMapper.INSTANCE;
    ResetPasswordMapper passwordMapper = ResetPasswordMapper.INSTANCE;
    private final JavaMailSender mailSender;

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
    public User findByEmail(String email) {
        User result = userRep.findByEmail(email);
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

    @Override
    public void resetPassword(ResetPasswordDto resetPasswordDto) {


        resetPasswordDto = passwordMapper.toDto(resetPasswordRep.save(passwordMapper.toEntity(resetPasswordDto)));

        settingEmail(resetPasswordDto);

    }

    @Override
    public void changePassword(ChangePasswordDto changePasswordDto) {
        User user = userRep.findByEmail(changePasswordDto.getEmail());
        user.setPassword(passwordEncoder.encode(changePasswordDto.getPassword()));
        userRep.save(user);
    }

    private void settingEmail(ResetPasswordDto dto) {
        String textSend = emailMapper.toString(dto);
        String subject = "Reset password username: " + dto.getUsername() + " dataTime: " + new Date();
        String email = dto.getEmail();

        try {
            send(email, subject, textSend);
            System.out.println("Message sent successfully....");
        } catch (Exception e) {
            throw new RuntimeException("Error sending email");
        }
    }

    @Override
    public void send(String to, String subject, String text) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("noreply@baeldung.com");
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);
        mailSender.send(message);
    }

    private User toEntity(UserDto userDto) {

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

        List<Genre> genres = new ArrayList<>();
        for (Genre item : userDto.getGenres()) {
            Genre genre = genreRep.findByName(item.getName());
            genres.add(genre);
        }
        user.setGenres(genres);

        return user;
    }
}
