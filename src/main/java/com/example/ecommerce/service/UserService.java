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

    //Method for Updating the User
    public User updateUser(User updatedUser, Integer id){
        User existingUser = userRepository.findById(id).orElseThrow(()-> new UserNotFound("This User Does not exists"));
        existingUser.setName(updatedUser.getName());
        existingUser.setAge(updatedUser.getAge());

        return userRepository.save(existingUser);

    }

    //Method for Deleting the User by ID
    public void deleteUser(Integer id){
        userRepository.deleteById(id);
    }

    //Method for Filtering Users by Name
    public List<User> getUserByName(String name){
        return userRepository.findByName(name);
    }

    //Method for Filtering Users by Age
    public List<User> getUserByAge(Integer age){ return userRepository.findByAge(age);}

    //Method for Filtering Age of the Users between Min and Max Age
    public List<User> getUserAgeBetween(Integer minAge, Integer maxAge){
        return userRepository.findByAgeBetween(minAge, maxAge);
    }

    //Method for filtering age
    public List<User> findByNameAndAge1(String name, int age){
        return userRepository.findByNameAndAge1(name, age);
    }
    //Method if the name contains the letter
    public List<User> findIfNameContains(String name){
        return userRepository.findIfNameContains(name);
    }
    //Method for obtaining the range of age
    public List<User> findMinAndMaxAge(int minAge, int maxAge){
        return userRepository.findByAgeBetween(minAge, maxAge);
    }




}
