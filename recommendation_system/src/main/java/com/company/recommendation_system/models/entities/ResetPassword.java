package com.company.recommendation_system.models.entities;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "tb_reset_password")
public class ResetPassword extends BaseEntity{
    @Column(name = "username")
    String username;
    @Column(name = "email")
    String email;
    @Column(name = "reset_token")
    String resetToken;

}
