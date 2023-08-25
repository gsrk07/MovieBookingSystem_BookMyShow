package com.scaler.BookMyShow.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Seat extends BaseModel {

    private int rowval;

    private int colval;

    private String seatNumber;

    @ManyToOne
    private SeatType seatType;
}
