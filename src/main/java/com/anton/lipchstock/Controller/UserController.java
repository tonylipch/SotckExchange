package com.anton.lipchstock.Controller;

import com.anton.lipchstock.Entity.User;
import com.anton.lipchstock.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/user")
public class UserController {

    private UserService service;

    @Autowired
    UserController(UserService userService){

        this.service = userService;
    }

    @GetMapping("/login/{userName}/{password}")
    public User userLogin(@PathVariable("userName") String userTag, @PathVariable("password") String password) throws Exception {
        return service.login(userTag, password);
    }

    @PutMapping("/logout")
    public String userLogout(@Valid @RequestBody User user, BindingResult result) {
        if (result.hasErrors())
            return "Error occured" + result;
        else
            return service.logout(user);
    }

    @PostMapping
    public String addUser(@Valid @RequestBody User user) throws Exception {
        service.addUser(user);
        return "User added successfully";
    }

    @DeleteMapping("/remove/{userId}")
    public String removeUser(@PathVariable("userId") User userId) throws Exception {
        service.deleteUser(userId);
        return "User with id " + userId + " deleted successfully";
    }

    @PutMapping
    public String updateUser(@Valid @RequestBody User user) throws Exception {
        service.updateUser(user);
        return "User updated successfully";
    }



}
