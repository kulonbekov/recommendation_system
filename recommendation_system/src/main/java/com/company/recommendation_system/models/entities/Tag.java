package com.company.recommendation_system.models.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Table(name = "tb_tag")
public class Tag extends BaseEntity{
    @Column(name = "name")
    String name;
    @JsonIgnore
    @ManyToMany(mappedBy = "tags" , fetch = FetchType.LAZY)
    List<Picture> pictures;
}
