package com.company.recommendation_system.models.entities;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "tb_role")
public class Role extends BaseEntity{

    @Column(name = "name")
    String name;
    @ManyToMany(mappedBy = "roles" , fetch = FetchType.LAZY)
    List<User> users;
}
