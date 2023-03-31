package com.company.recommendation_system.controller;

import com.company.recommendation_system.models.dtos.UserDto;
import com.company.recommendation_system.models.dtos.resetPassword.ChangePasswordDto;
import com.company.recommendation_system.models.dtos.resetPassword.ResetPasswordDto;
import com.company.recommendation_system.models.dtos.securityDto.AuthenticationRequestDto;
import com.company.recommendation_system.models.dtos.securityDto.AuthenticationResponseDto;
import com.company.recommendation_system.models.entities.ResetPassword;
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
import org.springframework.web.bind.annotation.*;

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
    private final UserRep userRep;

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

    @ApiOperation("Сброс пароля пользователя")
    @PostMapping("/reset-password")
    ResponseEntity<?> resetPassword(@RequestBody ResetPasswordDto resetPasswordDto){
        try{
            User user = userService.findByEmail(resetPasswordDto.getEmail());

            if(user == null) {
                throw new NullPointerException("The email address '" + resetPasswordDto.getEmail() + "' is invalid");
            }

            String token = jwtTokenProvider.createResetToken(user.getUsername(),user.getRoles());

            resetPasswordDto.setUsername(user.getUsername());
            resetPasswordDto.setResetToken(token);

            userService.resetPassword(resetPasswordDto);

            return ResponseEntity.ok("Message sent successfully....");
        }catch (Exception e){
            System.out.println(e.getMessage());
            return new ResponseEntity<>("Error sending email", HttpStatus.CONFLICT);
        }
    }
    @ApiOperation("Создать новый пароль пользователя")
    @PostMapping("/change-password")
    ResponseEntity<?> resetPassword(@RequestBody ChangePasswordDto changeDto) throws PasswordException{

        if(!jwtTokenProvider.validateToken(changeDto.getToken())){
            throw new RuntimeException("Token has expired");
        }
        if(!changeDto.getPassword().equals(changeDto.getPasswordConfirmation())){
            throw new RuntimeException("passwords do not match");
        }
        if(!passwordValidator.validate(changeDto.getPassword())){
            throw new PasswordException("The password '" + changeDto.getPassword() + "' is invalid");
        }
        if(userService.findByEmail(changeDto.getEmail()) == null) {
            throw new NullPointerException("The email address '" + changeDto.getEmail() + "' is invalid");
        }
        try{
            userService.changePassword(changeDto);
            return ResponseEntity.ok("Password changed successfully....");
        }catch (Exception e){
            return new ResponseEntity<>("Invalid change password" , HttpStatus.CONFLICT);
        }

    }

    private String toString(UserDto userDto){
        return "Registration completed successfully " +
                "\n username: " + userDto.getUsername() +
                "\n email: " + userDto.getEmail();
    }
}
