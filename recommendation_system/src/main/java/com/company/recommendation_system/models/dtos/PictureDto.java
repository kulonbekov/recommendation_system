package com.company.recommendation_system.models.dtos;

import com.company.recommendation_system.models.entities.Tag;
import com.company.recommendation_system.models.enums.Status;
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
public class PictureDto {

    Long id;
    Date created;
    Date updated;
    Status status;
    String name;
    String author;
    String image;
    int numberOfViews;
    List<Tag> tags;
}
