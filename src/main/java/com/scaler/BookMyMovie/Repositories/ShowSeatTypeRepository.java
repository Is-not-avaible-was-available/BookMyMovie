package com.scaler.BookMyMovie.Repositories;

import com.scaler.BookMyMovie.Models.Show;
import com.scaler.BookMyMovie.Models.ShowSeatType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShowSeatTypeRepository extends JpaRepository<ShowSeatType, Long>{
    List<ShowSeatType> findAllByShow(Show show);
}
