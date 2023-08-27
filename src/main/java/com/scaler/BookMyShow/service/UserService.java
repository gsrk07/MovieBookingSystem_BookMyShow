package com.scaler.BookMyShow.service;

import com.scaler.BookMyShow.models.User;

public interface UserService {

    User login(String emailid, String password);
    User signup(String name, String emailid, String password);
}
