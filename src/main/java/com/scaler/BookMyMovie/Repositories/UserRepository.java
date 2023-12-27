package com.scaler.BookMyMovie.Repositories;

import com.scaler.BookMyMovie.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    public User saveUser(User user);

    @Override
    Optional<User> findById(Long aLong);
}
