package com.example.bookmyshow.dtos;

import com.example.bookmyshow.models.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignUpResponseDTO {
    private User user;
    private ResponseStatus responseStatus;
}
