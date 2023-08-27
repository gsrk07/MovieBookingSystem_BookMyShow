package com.scaler.BookMyShow.repository;

import com.scaler.BookMyShow.models.ShowSeat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ShowSeatRepository extends JpaRepository<ShowSeat,Long> {

    @Override
    ShowSeat save(ShowSeat showSeat);

    @Override
    Optional<ShowSeat> findById(Long showseatid);
}
