package com.scaler.BookMyMovie.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
public class ShowSeat extends BaseModel{
    @ManyToOne
    private Show show;
    @ManyToOne
    private Seat seat;
    @Enumerated(value = EnumType.ORDINAL)
    private ShowSeatStatus showSeatStatus;
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date bookedAt;
}
