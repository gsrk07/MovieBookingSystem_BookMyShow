package com.scaler.BookMyShow.controller;

import com.scaler.BookMyShow.controller.utils.UserControllerUtils;
import com.scaler.BookMyShow.dto.UserSignUpRequestDto;
import com.scaler.BookMyShow.dto.UserSignUpResponseDto;
import com.scaler.BookMyShow.models.User;
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

        User user;
        UserSignUpResponseDto responseDto = new UserSignUpResponseDto();

        try {

            // first in the try block we will validate the usersignuprequestDTO
            UserControllerUtils.validateUserSignupRequestDTO(userSignUpRequestDto);
            // now we go ahead and create the user.
            user = userService.signup(userSignUpRequestDto.getName(),userSignUpRequestDto.getEmailid(),userSignUpRequestDto.getPassword());

            // instead of setting all values needed to responsedto before returning it, we can use a method that converts internal models into DTO.

            responseDto.setId(user.getId());
            responseDto.setName(user.getName());
            responseDto.setEmail(user.getEmail());
            responseDto.setTicketList(user.getTickets());
            responseDto.setResponsecode(200);
            responseDto.setResponsemessage("SUCCESS");
            return responseDto;
        } catch(Exception e){
            responseDto.setResponsecode(500);
            responseDto.setResponsemessage("Internal Server Error");
            return responseDto;
        }







    }


}
