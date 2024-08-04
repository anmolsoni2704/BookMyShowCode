package com.example.bookmyshow.controllers;

import com.example.bookmyshow.dtos.BookingMovieRequestDTO;
import com.example.bookmyshow.dtos.BookingMovieResponseDTO;
import com.example.bookmyshow.dtos.ResponseStatus;
import com.example.bookmyshow.models.Booking;
import com.example.bookmyshow.services.BookingService;
import org.springframework.stereotype.Controller;

@Controller
public class BookingController {
    private BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    public BookingMovieResponseDTO bookMovie(BookingMovieRequestDTO bookingMovieRequestDTO) {
        BookingMovieResponseDTO bookingMovieResponseDTO = new BookingMovieResponseDTO();

        try{
            Booking booking = bookingService.bookMovie(bookingMovieRequestDTO.getUserId(),
                    bookingMovieRequestDTO.getShowId(),
                    bookingMovieRequestDTO.getShowSeatIds());

            bookingMovieResponseDTO.setBooking(booking);
            bookingMovieResponseDTO.setResponseStatus(ResponseStatus.SUCCESS);
            return bookingMovieResponseDTO;
        } catch (Exception e){
            bookingMovieResponseDTO.setResponseStatus(ResponseStatus.SUCCESS);
            return bookingMovieResponseDTO;
        }
    }
}
