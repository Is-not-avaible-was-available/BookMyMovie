package com.scaler.BookMyMovie.Services;

import com.scaler.BookMyMovie.Exceptions.ShowNotFoundException;
import com.scaler.BookMyMovie.Exceptions.ShowSeatNotAvailableException;
import com.scaler.BookMyMovie.Exceptions.UserNotFoundException;
import com.scaler.BookMyMovie.Models.*;
import com.scaler.BookMyMovie.Repositories.BookingRepository;
import com.scaler.BookMyMovie.Repositories.ShowRepository;
import com.scaler.BookMyMovie.Repositories.ShowSeatRepository;
import com.scaler.BookMyMovie.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class BookingService {
    private ShowRepository showRepository;
    private UserRepository userRepository;
    private ShowSeatRepository showSeatRepository;
    private PricingService pricingService;
    private BookingRepository bookingRepository;

    @Autowired
    public BookingService(ShowRepository showRepository, UserRepository userRepository, ShowSeatRepository showSeatRepository, PricingService pricingService, BookingRepository bookingRepository) {
        this.showRepository = showRepository;
        this.userRepository = userRepository;
        this.showSeatRepository = showSeatRepository;
        this.pricingService = pricingService;
        this.bookingRepository = bookingRepository;
    }

    @Transactional(isolation = Isolation.SERIALIZABLE)
    public Booking bookMovie(Long showId, Long userId, List<Long>showSeatIds)
            throws ShowNotFoundException, UserNotFoundException, ShowSeatNotAvailableException{
        Optional<Show> optionalShow = showRepository.findById(showId);
        if(optionalShow.isEmpty()){
            throw new ShowNotFoundException();
        }
        Show show = optionalShow.get();

        Optional<User>optionalUser = userRepository.findById(userId);
        if(optionalUser.isEmpty()){
            throw new UserNotFoundException();
        }
        User user = optionalUser.get();
        List<ShowSeat> showSeats = showSeatRepository.findAllById(showSeatIds);

        for(ShowSeat showSeat: showSeats){
            if(!(showSeat.getShowSeatStatus().equals(ShowSeatStatus.AVAILABLE) ||
                    (showSeat.getShowSeatStatus().equals(ShowSeatStatus.BLOCKED) &&
                            Duration.between(showSeat.getBookedAt().toInstant(),
                                    new Date().toInstant()).toMinutes() > 15))){
                throw new ShowSeatNotAvailableException("Something went wrong");
            }
        }
        List<ShowSeat>savedShowSeat = new ArrayList<>();
        for(ShowSeat showSeat:showSeats){
            showSeat.setBookedAt(new Date());
            showSeat.setShowSeatStatus(ShowSeatStatus.BLOCKED);
            savedShowSeat.add(showSeatRepository.save(showSeat));
        }
        Booking booking = new Booking();
        booking.setBookedAt(new Date());
        booking.setAmount(pricingService.calculatePrice(savedShowSeat, show));
        booking.setBookingStatus(BookingStatus.PENDING);
        booking.setBookingNumber("BookingNumber: "+"this is the number");
        booking.setShowSeats(savedShowSeat);
        booking.setUser(user);
        booking.setShow(show);

        return bookingRepository.save(booking);
    }
}
