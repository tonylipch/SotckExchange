package com.anton.lipchstock.controller;



import com.anton.lipchstock.dto.NewUserDto;
import com.anton.lipchstock.dto.UserDto;
import com.anton.lipchstock.entity.User;
import com.anton.lipchstock.exceptions.BadRequestRuntimeException;
import com.anton.lipchstock.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


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
    public String addUser( @RequestBody NewUserDto user) throws Exception, BadRequestRuntimeException {

        service.addUser(user);
        return "User added successfully";


    }

    @DeleteMapping("/remove/{userId}")
    public String removeUser(@PathVariable("userId") User userId) throws Exception {
        service.deleteUser(userId);
        return "User with id " + userId + " deleted successfully";
    }

    @PutMapping
    public ResponseEntity<String> updateUser(@Valid @RequestBody UserDto user, @PathVariable Long id) throws Exception {

        try {
            service.updateUser(user,id);
            return  ResponseEntity.ok().body("User updated successfully");


        }catch (Exception e){

            return  ResponseEntity.badRequest().body("User dont updated");


        }

    }



}
