package com.realestate.demo.Controller;
import com.realestate.demo.Entity.User;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.web.bind.annotation.*;
import com.realestate.demo.Service.UserService;

import java.util.List;

@RestController
@RequestMapping("/users")

public class UserController {

    User user;

    UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }


    // Tek bir kullanıcının bilgileri
    @GetMapping("{userID}")
    public User getUser(@PathVariable("userID") Integer userID)
    {

        return userService.getUser(userID);
    }
    // Tüm kullanıcıların bilgileri

    @GetMapping()
    public List<User> getAllUsers()
    {
        return userService.getAllUsers();
    }



    @PostMapping
    public String createUser(@RequestBody User user){

        userService.createUser(user);
        return "User created successfully";

    }
@PutMapping
    public String updateUser(@RequestBody User user)
{
    userService.updateUser(user);
    return "User updated successfully";
}

    @DeleteMapping("{userID}")
    public String deleteUser(@PathVariable Integer userID) {

      userService.deleteUser(userID);
        return "User deleted successfully";
    }









}
