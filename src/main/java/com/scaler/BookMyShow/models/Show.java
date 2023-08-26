package com.scaler.BookMyShow.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity
public class Show extends  BaseModel {

    @ManyToOne // relation between Show to Movie.

    private Movie movie;

    private LocalDateTime startTime;

    private LocalDateTime endTime;

    private List<ShowSeat> showseats;

    @ManyToOne
    private Screen screen;

    @Enumerated(EnumType.ORDINAL)
    @ElementCollection // here we are using element collection since a show can have multiple features
    private List<Feature> features; // this Feature is an ENUM. Hence the 2 annotations will create a table for Enum and mapping between Show and features.
}
