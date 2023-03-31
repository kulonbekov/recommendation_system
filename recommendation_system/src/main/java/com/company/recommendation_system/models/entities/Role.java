package com.company.recommendation_system.models.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "tb_role")
public class Role extends BaseEntity{

    @Column(name = "name", unique = true)
    @NotNull
    String name;
    @JsonIgnore
    @ManyToMany(mappedBy = "roles" , fetch = FetchType.LAZY)
    List<User> users;
}
