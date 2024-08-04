package com.example.bookmyshow.dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class BookingMovieRequestDTO {
    private Long userId;
    private Long showId;
    private List<Long> showSeatIds;
}
