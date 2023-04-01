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
@Table(name = "tb_genre")
public class Genre extends BaseEntity{

    @Column(name = "name", unique = true)
    @NotNull
    String name;
    @JsonIgnore
    @ManyToMany(mappedBy = "genres" , fetch = FetchType.LAZY)
    List<Music> musics;
}
