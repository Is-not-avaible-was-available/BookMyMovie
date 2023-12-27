package com.scaler.BookMyMovie.Repositories;

import com.scaler.BookMyMovie.Models.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {
    public Booking save(Booking booking);

    @Override
    Optional<Booking> findById(Long aLong);
}
