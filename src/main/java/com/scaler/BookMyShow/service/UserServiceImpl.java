package com.scaler.BookMyShow.service;

import com.scaler.BookMyShow.exceptions.InvalidCredentialException;
import com.scaler.BookMyShow.exceptions.UserAlreadyPresentException;
import com.scaler.BookMyShow.exceptions.UserNotFoundException;
import com.scaler.BookMyShow.models.User;
import com.scaler.BookMyShow.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class UserServiceImpl implements UserService{

    // we know that Service interacts with Repository.
    // we also know that in this class, UserRepository object is being used. so we to create the object
    // and handle the dependency of the repo class in this class, we make this as @AutoWired

    @Autowired
    private UserRepository userRepository;

    @Override
    public User login(String emailid, String password) {

        Optional<User> userOptional = userRepository.findByEmail(emailid);

        if(userOptional.isEmpty()){
            throw new UserNotFoundException("No user found with this email-id: " + emailid);
        }

        User user = userOptional.get(); // this indicates that i have got the user from repo.

        if(user.getPassword().equals(password)){
            return user;
        }
        else {
            throw new InvalidCredentialException("Invalid credentials provided");
        }

    }

    @Override
    public User signup(String name, String emailid, String password) {

        // before signing up, check if we have an user with the following name or emailid.

        Optional<User> userOptional = userRepository.findByEmail(emailid);

        if(userOptional.isPresent()){
            throw new UserAlreadyPresentException("User already is signedup with this emailid " + emailid);
        }

        else {

            User newuser = new User();
            newuser.setName(name);
            newuser.setPassword(password);
            newuser.setEmail(emailid);

            return userRepository.save(newuser);

        }

    }
}
