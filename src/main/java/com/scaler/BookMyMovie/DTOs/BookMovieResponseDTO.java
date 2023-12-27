package com.scaler.BookMyMovie.DTOs;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookMovieResponseDTO {
    private Long bookingId;
    private ResponseStatus responseStatus;
    private String failureMessage;
    private int amount;
}
