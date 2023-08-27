package com.scaler.BookMyShow.repository;

import com.scaler.BookMyShow.models.Movie;
import com.scaler.BookMyShow.models.MovieShow;
import jakarta.persistence.ManyToOne;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MovieShowRepository extends JpaRepository<MovieShow,Long> {

    @Override
    Optional<MovieShow> findById(Long MovieShowid);

    @Override
    MovieShow save(MovieShow movieShow);

}
