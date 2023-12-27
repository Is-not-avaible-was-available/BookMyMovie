package com.scaler.BookMyMovie.Services;

import com.scaler.BookMyMovie.Models.Show;
import com.scaler.BookMyMovie.Models.ShowSeat;
import com.scaler.BookMyMovie.Models.ShowSeatType;
import com.scaler.BookMyMovie.Repositories.ShowSeatTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PricingService {
    private ShowSeatTypeRepository showSeatTypeRepository;

    @Autowired
    public PricingService(ShowSeatTypeRepository showSeatTypeRepository) {
        this.showSeatTypeRepository = showSeatTypeRepository;
    }

    public int calculatePrice(List<ShowSeat> showSeats, Show show){
        List<ShowSeatType> showSeatTypes = showSeatTypeRepository.findAllByShow(show);
        int amount = 0;
        for(ShowSeatType showSeatType: showSeatTypes){
            for (ShowSeat showSeat: showSeats){
                if(showSeatType.getSeatType().equals(showSeat.getSeat().getSeatType())){
                    amount+=showSeatType.getPrice();
                    break;
                }
            }
        }
        return amount;
    }

}
