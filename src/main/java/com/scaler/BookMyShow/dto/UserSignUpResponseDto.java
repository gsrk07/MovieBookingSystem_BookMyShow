package com.scaler.BookMyShow.dto;

import com.scaler.BookMyShow.models.Ticket;

import java.util.List;

public class UserSignUpResponseDto {

    private Long Id;
    private String name;
    private String email;

    private List<Ticket> ticketList; // TODO Instead of Ticket we should use TicketresponseDTO.

}
