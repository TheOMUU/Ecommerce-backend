package com.example.ecommerce.service;

import com.example.ecommerce.entity.User;
import com.example.ecommerce.exception.UserNotFound;
import com.example.ecommerce.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

//Method for Fetching the Users
    public List<User> getUser(){
        return userRepository.findAll();
    }
//Method for Creating new Users
    public User createUser(User user){
        return userRepository.save(user);
    }
//Method for Fetching Users by ID
    public User getUserByID(Integer id){
        return userRepository.findById(id).orElseThrow(()-> new UserNotFound("Student Does not Exists with this id " + id));
    }
}
