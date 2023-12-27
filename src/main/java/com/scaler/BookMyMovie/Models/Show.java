package com.scaler.BookMyMovie.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;
@Entity(name = "shows")
@Getter
@Setter
public class Show extends BaseModel{
    private Date startTime;
    private Date endTime;
    @ManyToOne
    private Movie movie;
    @ManyToOne
    private Screen screen;

    @Enumerated(value = EnumType.ORDINAL)
    @ElementCollection
    private List<Feature> features;

}
