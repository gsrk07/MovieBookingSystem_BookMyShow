package com.scaler.BookMyShow.service;

import com.scaler.BookMyShow.exceptions.TicketNotFoundException;
import com.scaler.BookMyShow.exceptions.UserNotFoundException;
import com.scaler.BookMyShow.models.*;
import com.scaler.BookMyShow.repository.ShowSeatRepository;
import com.scaler.BookMyShow.repository.TicketRepository;
import com.scaler.BookMyShow.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TicketServiceImpl implements TicketService{
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ShowSeatRepository showSeatRepository;

    @Autowired
    private TicketRepository ticketRepository;

    @Override
    public Ticket bookTicket(Long userId, List<Long> ShowSeatIDs, Long showID) {

        return null;

    }

    @Override
    public Ticket cancelTicket(Long TicketId) {

        Optional<Ticket> ticketOptional = ticketRepository.findById(TicketId);
        if(ticketOptional.isEmpty()){
            throw new TicketNotFoundException("No ticket found with this ticket id to cancel" + TicketId);
        }

        Ticket ticket = ticketOptional.get(); // this gets the ticket from optional
        ticket.setBookingStatus(BookingStatus.CANCELLED);

        for(ShowSeat showSeat : ticket.getShowseats()){
            showSeat.setShowSeatStatus(ShowSeatStatus.AVAILABLE);
            showSeatRepository.save(showSeat);
        }

        ticketRepository.save(ticket);

        // if we want to initiate refund, then we will have to send to 3rd party the ref no
        for (Payment p : ticket.getPayments()){
            p.getRefNo();
            // we can send the message for refund.
        }

        return ticket;
    }

    @Override
    public Ticket transferTicket(Long TicketId, Long fromuserid, Long toUserid) {

        Optional<Ticket> ticketOptional = ticketRepository.findById(TicketId);
        if(ticketOptional.isEmpty()){
            throw new TicketNotFoundException("No ticket found with this ticket id to cancel" + TicketId);
        }

        Optional<User> fromuserOptional = userRepository.findById(fromuserid);
        Optional<User> touserOptional = userRepository.findById(toUserid);

        if(fromuserOptional.isEmpty() || touserOptional.isEmpty()){
            throw new UserNotFoundException("User details given for the ticket number are not found");
        }

        Ticket ticket = ticketOptional.get();
        User fromuser = fromuserOptional.get();
        List<Ticket> fromuserticketlist = fromuser.getTickets();
        fromuserticketlist.remove(ticket);
        userRepository.save(fromuser);

        User toUser = touserOptional.get();
        List<Ticket> touserticketlist = toUser.getTickets();
        touserticketlist.add(ticket);
        toUser = userRepository.save(toUser); // saving the user back to repository

        ticket.setUser(toUser); // now adding the ticket to the toUser as well.
        return ticketRepository.save(ticket); // now saving the updated ticket to repository
    }
}
