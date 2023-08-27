package com.scaler.BookMyShow.models;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class ShowSeat extends BaseModel{

    @ManyToOne
    private MovieShow show;

    @Enumerated(EnumType.ORDINAL)
   // @ElementCollection we dont need a collection since for one showseat, there will be only one status.
    private ShowSeatStatus showSeatStatus;

    @ManyToOne
    private Seat seat;

    private double price;

}
