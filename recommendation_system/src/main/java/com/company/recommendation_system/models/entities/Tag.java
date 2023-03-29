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
@Table(name = "tb_tag")
public class Tag extends BaseEntity{
    @Column(name = "name")
    String name;
}
