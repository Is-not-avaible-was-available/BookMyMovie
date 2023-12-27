package com.scaler.BookMyMovie.Controller;

import com.scaler.BookMyMovie.DTOs.RegisterUserRequestDTO;
import com.scaler.BookMyMovie.DTOs.RegisterUserResponseDTO;
import com.scaler.BookMyMovie.DTOs.ResponseStatus;
import com.scaler.BookMyMovie.Models.User;
import com.scaler.BookMyMovie.Services.RegisterUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class RegisterUserController {

    private RegisterUserService registerUserService;
    @Autowired
    public RegisterUserController(RegisterUserService registerUserService) {
        this.registerUserService = registerUserService;
    }
    public RegisterUserResponseDTO registerUser(RegisterUserRequestDTO request){
        RegisterUserResponseDTO response = new RegisterUserResponseDTO();

        User user;

        try{
            user = registerUserService.registerUser(request.getName(), request.getEmail(),
                    request.getPassword());

            response.setUserId(user.getId());
            response.setResponseStatus(ResponseStatus.SUCCESS);
        }catch (Exception ex){
            response.setResponseStatus(ResponseStatus.FAILURE);
            response.setFailureMessage(ex.getMessage());
        }

        return response;
    }
}
