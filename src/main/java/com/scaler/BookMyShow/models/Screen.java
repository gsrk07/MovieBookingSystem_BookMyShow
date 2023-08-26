package com.scaler.BookMyShow.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Screen extends BaseModel{

    private String name;

    @OneToMany
    private List<Seat> seats;

    @Enumerated(EnumType.ORDINAL)
    @ElementCollection // here we are adding ElementCollection annotation since Screen has multiple features and to create a one to many type relation for an ENUM we write element collection
    private List<Feature> features; // note Feature is an ENUM Hence, way of handling ENUM in DB is using the 2 above annotations.
}
