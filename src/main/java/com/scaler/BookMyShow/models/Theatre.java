package com.scaler.BookMyShow.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Theatre extends BaseModel{

    private String name;

    @ManyToOne // this is the relation from theatre to Region
    private Region region;

    @OneToMany // this is the relation from Theatre to Screen
    private List<Screen> screens;

}
