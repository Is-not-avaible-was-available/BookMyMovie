package com.scaler.BookMyMovie.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class ShowSeatType extends BaseModel{
    @ManyToOne
    private SeatType seatType;
    @ManyToOne
    private Show show;
    private int price;
}
