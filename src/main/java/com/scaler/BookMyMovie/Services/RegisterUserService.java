package com.scaler.BookMyMovie.Services;

import com.scaler.BookMyMovie.Models.User;
import com.scaler.BookMyMovie.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RegisterUserService {
    private UserRepository userRepository;

    @Autowired
    public RegisterUserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User registerUser(String name, String email, String password){
        User user = new User();
        user.setEmail(email);
        user.setName(name);
        user.setPassword(password);
        return userRepository.saveUser(user);
    }
}
