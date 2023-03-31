package com.company.recommendation_system.controller;

import com.company.recommendation_system.models.dtos.UserDto;
import com.company.recommendation_system.models.dtos.securityDto.AuthenticationRequestDto;
import com.company.recommendation_system.models.dtos.securityDto.AuthenticationResponseDto;
import com.company.recommendation_system.models.entities.User;
import com.company.recommendation_system.repository.UserRep;
import com.company.recommendation_system.security.emailValidator.EmailException;
import com.company.recommendation_system.security.emailValidator.EmailValidator;
import com.company.recommendation_system.security.jwt.JwtTokenProvider;
import com.company.recommendation_system.security.passwordValidator.PasswordException;
import com.company.recommendation_system.security.passwordValidator.PasswordValidator;
import com.company.recommendation_system.services.UserService;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.sql.SQLOutput;

@Api(tags = "1. Авторизация/Регистрация")
@RestController
@RequestMapping(value = "/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationRestControllerV1 {

    private final AuthenticationManager authenticationManager;
    private final JwtTokenProvider jwtTokenProvider;
    private final UserService userService;
    private final EmailValidator emailValidator;
    private final PasswordValidator passwordValidator;

    @ApiOperation("Авторизация")
    @PostMapping("/login")
    public ResponseEntity login(@RequestBody AuthenticationRequestDto requestDto){
        try{
            String username = requestDto.getUsername();

            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username,requestDto.getPassword()));
            User user = userService.findByUsername(username);

            String token = jwtTokenProvider.createToken(username, user.getRoles());

            AuthenticationResponseDto responseDto = new AuthenticationResponseDto();
            responseDto.setUsername(username);
            responseDto.setToken(token);

            return ResponseEntity.ok(responseDto);
        } catch (AuthenticationException e){
            return new ResponseEntity<>("Invalid username or password", HttpStatus.NOT_FOUND);

        }
    }

    @ApiOperation("Регистрация")
    @PostMapping("/register")
    public ResponseEntity register(@RequestBody UserDto userDto) throws EmailException,PasswordException {
        try{
            if(!emailValidator.validate(userDto.getEmail())){
                throw new EmailException("The email address '" + userDto.getEmail() + "' is invalid");
            }
            if(!passwordValidator.validate(userDto.getPassword())){
                throw new PasswordException("The password '" + userDto.getPassword() + "' is invalid");
            }
            return ResponseEntity.ok(toString(userService.register(userDto)));
        }catch (RuntimeException e){
            throw new RuntimeException("Invalid save User: " + userDto.getUsername()+ " ");
        }
    }

    private String toString(UserDto userDto){
        return "Registration completed successfully " +
                "\n username: " + userDto.getUsername() +
                "\n email: " + userDto.getEmail();
    }
}
