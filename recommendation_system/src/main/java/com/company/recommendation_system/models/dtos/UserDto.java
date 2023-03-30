package com.company.recommendation_system.models.dtos;

import com.company.recommendation_system.models.entities.Role;
import com.company.recommendation_system.models.enums.Gender;
import com.company.recommendation_system.models.enums.Status;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserDto {

    Long id;
    @JsonFormat(pattern = "dd.MM.yyyy HH:mm")
    Date created;
    @JsonFormat(pattern = "dd.MM.yyyy HH:mm")
    Date updated;
    Status status;
    String username;
    String email;
    String password;
    Gender gender;
    int age;
    List<Role> roles;

}
