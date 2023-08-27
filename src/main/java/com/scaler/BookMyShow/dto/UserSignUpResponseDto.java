package com.scaler.BookMyShow.dto;

import com.scaler.BookMyShow.models.Ticket;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class UserSignUpResponseDto {

    private Long Id;
    private String name;
    private String email;
    private int responsecode;
    private String responsemessage;
    private List<Ticket> ticketList; // TODO Instead of Ticket we should use TicketresponseDTO.

}
