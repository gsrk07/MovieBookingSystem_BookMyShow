package com.scaler.BookMyShow.controller;

import com.scaler.BookMyShow.dto.UserSignUpRequestDto;
import com.scaler.BookMyShow.dto.UserSignUpResponseDto;
import com.scaler.BookMyShow.service.UserService;
import com.scaler.BookMyShow.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {

    @Autowired
    private UserService userService; // SINCE IT IS A GOOD PRACTICE TO DEPEND ON AN INTERFACE RATHER THAN A CONCRETE CLASS

    // private UserServiceImpl userserviceImpl;

    // should we use models for input/output directly or do something else?

    // we will use dto's for input and output access.

    public UserSignUpResponseDto usersignup(UserSignUpRequestDto userSignUpRequestDto){


    }


}
