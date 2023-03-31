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
@Table(name = "tb_picture")
public class Picture extends BaseEntity{

    @Column(name = "name")
    String name;
    @Column(name = "author")
    String author;
    @Column(name = "image" , unique = true)
    String image;
    @Column(name = "number_of_views")
    int numberOfViews;
    @JsonIgnore
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "tb_picture_tag",
            joinColumns = {@JoinColumn(name = "picture_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "tag_id", referencedColumnName = "id")})
    List<Tag> tags;

}
