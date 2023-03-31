package com.company.recommendation_system.models.dtos.resetPassword;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ChangePasswordDto {

    String email;
    String token;
    String password;
    String passwordConfirmation;
}
