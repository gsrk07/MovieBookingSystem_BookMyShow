package com.scaler.BookMyShow.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserSignUpRequestDto {

    // what details we want to pass at request?
    private String name;
    private String password;
    private String emailid;


}
