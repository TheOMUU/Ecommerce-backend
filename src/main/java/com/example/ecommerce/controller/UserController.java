package com.example.ecommerce.controller;

import com.example.ecommerce.entity.User;
import com.example.ecommerce.service.UserService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    private final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping("/users")
    public List<User> getAll(){
        return userService.getUser();
    }

    @PostMapping("/users")
    public User createUser(@Valid @RequestBody User user){
        return userService.createUser(user);
    }

    @GetMapping("/users/{id}")
    public User getUserByID(@PathVariable Integer id){
        return userService.getUserByID(id);
    }

    @PutMapping("/users")
    public User updateUser(@Valid @RequestBody User user, @PathVariable Integer id){
        return userService.updateUser(user, id);
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable Integer id){
        userService.deleteUser(id);
    }

    @GetMapping(value = "/users", params = "name")
    public List<User> getUserByName(@RequestParam(name = "name") String name){
        return userService.getUserByName(name);
    }

    @GetMapping(value = "/users", params = "age")
    public List<User> getUserByAge(@RequestParam Integer age){
        return userService.getUserByAge(age);
    }

}
