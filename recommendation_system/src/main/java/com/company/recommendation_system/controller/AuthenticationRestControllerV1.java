package com.company.recommendation_system.controller;

import com.company.recommendation_system.models.dtos.UserDto;
import com.company.recommendation_system.models.dtos.securityDto.AuthenticationRequestDto;
import com.company.recommendation_system.models.dtos.securityDto.AuthenticationResponseDto;
import com.company.recommendation_system.models.entities.User;
import com.company.recommendation_system.security.jwt.JwtTokenProvider;
import com.company.recommendation_system.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationRestControllerV1 {

    private final AuthenticationManager authenticationManager;
    private final JwtTokenProvider jwtTokenProvider;
    private final UserService userService;

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

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody UserDto userDto){
        try{
            userDto = userService.register(userDto);

            String result = "Registration completed successfully " +
                    "\n username: " + userDto.getUsername() +
                    "\n email: " + userDto.getEmail();

            return ResponseEntity.ok(result);
        }catch (Exception e){
            throw new RuntimeException("Invalid save User: " + userDto.getUsername());
        }
    }
}
