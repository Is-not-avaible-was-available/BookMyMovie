package com.scaler.BookMyMovie.Controller;

import com.scaler.BookMyMovie.DTOs.BookMovieRequestDTO;
import com.scaler.BookMyMovie.DTOs.BookMovieResponseDTO;
import com.scaler.BookMyMovie.DTOs.ResponseStatus;
import com.scaler.BookMyMovie.Models.Booking;
import com.scaler.BookMyMovie.Services.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class BookingController {
    private BookingService bookMovieService;

    @Autowired
    public BookingController(BookingService bookMovieService) {
        this.bookMovieService = bookMovieService;
    }

    public BookMovieResponseDTO bookMovie(BookMovieRequestDTO request){
        BookMovieResponseDTO response = new BookMovieResponseDTO();

        Booking booking;

        try{
            booking = bookMovieService.bookMovie(request.getShowId(),
                    request.getUserId(), request.getShowSeatIds()
                    );
            response.setResponseStatus(ResponseStatus.SUCCESS);
            response.setBookingId(booking.getId());
            response.setAmount(booking.getAmount());
        }catch (Exception ex){
            response.setResponseStatus(ResponseStatus.FAILURE);
            response.setFailureMessage(ex.getMessage());
        }
        return response;
    }
}
