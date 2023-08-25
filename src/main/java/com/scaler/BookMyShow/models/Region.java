package com.scaler.BookMyShow.models;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity // in this case it will take className as tableName, else we can do @Entity(name = "tableName")
public class Region extends BaseModel{

    private String name;

    // the cardinality of a region to theatre is 1:M so 1 region has many theatres.
    // we can define the same to the DB by writing it as follows:
    @OneToMany
    private List<Theatre> theatre;

}
