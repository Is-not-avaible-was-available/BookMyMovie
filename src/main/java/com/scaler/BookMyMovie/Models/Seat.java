package com.scaler.BookMyMovie.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class Seat extends BaseModel{
    private int seatNumber;
    private int rowVal;
    private int colVal;
    @ManyToOne
    private SeatType seatType;
}
