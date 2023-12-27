package com.scaler.BookMyMovie.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Screen extends BaseModel{
    private String screenName;
    @Enumerated(value = EnumType.ORDINAL)
    @ElementCollection
    private List<Feature> features;
    @OneToMany
    private List<Seat> seats;
}
