package com.anton.lipchstock.controller;



import com.anton.lipchstock.dto.NewUserDto;
import com.anton.lipchstock.entity.User;
import com.anton.lipchstock.exceptions.BadRequestRuntimeException;
import com.anton.lipchstock.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.lang.reflect.Array;
import java.util.List;
import java.util.stream.DoubleStream;


@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService service;




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
    public String addUser(@Valid @RequestBody NewUserDto user) throws Exception, BadRequestRuntimeException {
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
