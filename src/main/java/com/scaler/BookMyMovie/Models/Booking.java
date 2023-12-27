package com.scaler.BookMyMovie.Models;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
public class Booking extends BaseModel{
    private String bookingNumber;
    @ManyToOne
    private User user;
    @ManyToOne
    private Show show;
    @OneToMany
    private List<ShowSeat>showSeats;
    @Enumerated(value = EnumType.ORDINAL)
    private BookingStatus bookingStatus;
    private int amount;
    @OneToMany
    private List<Payment> payments;
    private Date bookedAt;
}
