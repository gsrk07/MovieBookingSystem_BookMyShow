package com.scaler.BookMyShow.service;

import com.scaler.BookMyShow.models.Ticket;

import java.util.List;

public interface TicketService {

    Ticket bookTicket(Long userId, List<Long> ShowSeatIDs, Long showID);

    Ticket cancelTicket(Long TicketId);

    Ticket transferTicket(Long TicketId, Long fromuserid, Long toUserid);

}
