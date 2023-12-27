package com.scaler.BookMyMovie.DTOs;

import com.scaler.BookMyMovie.Models.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterUserResponseDTO {
    private Long userId;
    private ResponseStatus responseStatus;
    private String failureMessage;
}
