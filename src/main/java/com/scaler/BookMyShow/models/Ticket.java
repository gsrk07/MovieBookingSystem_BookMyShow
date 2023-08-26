package com.scaler.BookMyShow.models;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.List;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
public class Ticket extends BaseModel {

    @Enumerated(EnumType.ORDINAL)
    private BookingStatus bookingStatus;

    @ManyToOne
    private Show show; // Many tickets become part of a single show hence ticket to show is Many to one.

    @OneToMany
    private List<Payment> payments; // one ticket can have multiple payment methods due to partial payment supported.

    @ManyToOne
    private User user; // user can book multiple tickets.

    @ManyToMany
    private List<ShowSeat> showseats; // relation between Ticket and ShowSeat

    private LocalDateTime bookedAt;

    private double amount;

}

/*
    Cardinality explained for Ticket to ShowSeat
    Suppose Ticket 1 bought Seat1 -- later cancelled it
            Ticket 2 bought Seat1 -- later cancelled it
            Ticket 3 bought Seat 1.

             1 showseat is having multiple tickets

            so if we go and check the order history for Ticket 1 and Ticket 2, we do find the Seat details are mentioned.

            Ticket 4 bought Seat1,2,3.
            --> 1 ticket can have multiple Showseats


 */