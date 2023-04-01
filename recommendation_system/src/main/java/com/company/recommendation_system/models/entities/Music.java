package com.company.recommendation_system.models.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "tb_music")
public class Music extends BaseEntity{

    @Column(name = "name")
    String name;
    @Column(name = "author")
    String author;
    @Column(name = "album")
    String album;
    @Column(name = "image")
    String image;
    @JsonIgnore
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "tb_music_genre",
            joinColumns = {@JoinColumn(name = "music_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "genre_id", referencedColumnName = "id")})
    List<Genre> genres;
    @Column(name = "song")
    String song;
    @Column(name = "date_of_issue")
    int dateOfIssue;
    @Column(name = "number_of_plays")
    float numberOfPlays;
}
