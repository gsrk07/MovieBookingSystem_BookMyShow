package com.scaler.BookMyShow.repository;


import com.scaler.BookMyShow.models.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TicketRepository extends JpaRepository<Ticket,Long>{

    // finding ticket using TicketId
    @Override
    Optional<Ticket> findById(Long TicketId);

    // Optional is used when we may or may not have the datatype which we will get. Optional is used also when we want to avoid null pointer exception.

    @Override
    Ticket save(Ticket ticket);

    // HERE WE ARE NOT WRITING ANY LOGIC FOR THESE ENTITIES. JPA REPOSITORY TAKES CARE.
}
