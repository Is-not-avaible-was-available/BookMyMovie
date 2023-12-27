package com.scaler.BookMyMovie.DTOs;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class RegisterUserRequestDTO {
    private String email;
    private String name;
    private String password;
}
