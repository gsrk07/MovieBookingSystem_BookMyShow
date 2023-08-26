package com.scaler.BookMyShow.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

import java.security.cert.Certificate;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
public class Movie extends BaseModel{

    private String moviename;

    private String description;

    private String posterlink;

    private String language;

    private LocalDateTime releaseDate;

    private Long ratings;
}
