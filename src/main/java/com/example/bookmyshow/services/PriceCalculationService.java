package com.example.bookmyshow.services;

import com.example.bookmyshow.models.SeatType;
import com.example.bookmyshow.models.Show;
import com.example.bookmyshow.models.ShowSeat;
import com.example.bookmyshow.models.ShowSeatType;
import com.example.bookmyshow.repositories.ShowSeatTypeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PriceCalculationService {
    private final ShowSeatTypeRepository showSeatTypeRepository;

    public PriceCalculationService(ShowSeatTypeRepository showSeatTypeRepository) {
        this.showSeatTypeRepository = showSeatTypeRepository;
    }

    public int calculatePrice(List<ShowSeat> showSeats, Show show) {
        List<ShowSeatType> showSeatTypes = showSeatTypeRepository.findAllByShow(show);

         /*
        Show SeatType price
        1       1       100
        1       2       200
        1       3       300
        1       4       250
        1       5       80
        1       6       1000

         */
        int totalAmount = 0;
        for(ShowSeat showSeat : showSeats) {
             /*
            price of the current show seat
             */
            SeatType seatType = showSeat.getSeat().getSeatType();
            //Optional<ShowSeatType> showSeat1 = showSeatTypeRepository.findBySeatType(seatType);
            // show, seattype, price
            //totalAmount += showSeat1.get().getPrice();
            for(ShowSeatType showSeatType : showSeatTypes){
                if(showSeatType.equals(seatType)){
                    totalAmount += showSeatType.getPrice();
                    break;
                }
            }
        }
        return totalAmount;
    }
}
