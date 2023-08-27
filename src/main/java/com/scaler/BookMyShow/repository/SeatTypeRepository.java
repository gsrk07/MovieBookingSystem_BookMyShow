package com.scaler.BookMyShow.repository;

import com.scaler.BookMyShow.models.SeatType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SeatTypeRepository extends JpaRepository<SeatType,Long> {

    @Override
    SeatType save(SeatType seatType);

    @Override
    Optional<SeatType> findById(Long seattypeId);

}
