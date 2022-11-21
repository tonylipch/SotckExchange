package com.anton.lipchstock.service;



import com.anton.lipchstock.dto.NewUserDto;
import com.anton.lipchstock.dto.UserDto;
import com.anton.lipchstock.entity.User;
import com.anton.lipchstock.exceptions.BadRequestRuntimeException;

import com.anton.lipchstock.repository.UserRepository;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private  final UserRepository userRepository;

    Logger log = LoggerFactory.getLogger(UserService.class);

    public UserDto addUser(@Valid NewUserDto userDto) throws Exception, BadRequestRuntimeException {
        log.info("method :'Add user' has been invoked");
        Optional<User> found = userRepository.findByUserTag(userDto.getLogin());
        if (found.isPresent()) {
            throw new BadRequestRuntimeException("User %s already exists");

        }
        User user = new User();
        user.setUserTag(userDto.getLogin());
        user.setPassword(userDto.getPassword());
        user = userRepository.save(user);
        return toDto(user);
    }

    private UserDto toDto(User user) {
        UserDto dto = new UserDto();
        dto.setId(user.getUserId());
        dto.setLogin(user.getUserTag());
        dto.setPassword(user.getPassword());
        return dto;
    }

    public boolean deleteUser (User user)throws  Exception{

        log.info("method : 'Remove user' has been invoked");
        if (userRepository.existsById(user.getUserId())){
            userRepository.deleteById(user.getUserId());

            log.info ("User with tag: "+user.getUserTag()+"\n User id: "+user.getUserId()+" has been removed");
            return true;
        }
        log.warn("User with id : "+user.getUserId() +" not found");

        throw new Exception("User not found with id "+user.getUserId());

    }

    public boolean updateUser (User user) throws Exception {
        log.info("method: 'Update user' has been invoked");

        if (userRepository.existsById(user.getUserId())){
            userRepository.save(user);
            log.info("User with id "+user.getUserId()+" updated");
            return true;
        }
        log.warn("UserNotFoundException thrown...Delete Failed, User not found with id "+user.getUserTag());
        throw new Exception("User not found with id "+user.getUserId());

    }


    public User login(String usertag, String password) throws Exception {
        log.info("login() invoked");
        User user = userRepository.findByUserTagAndPassword(usertag, password);
        if(user == null) {
            log.error("UserNotFoundException thrown...Login Failed, username or password is incorrect");
            throw new Exception("username or password is incorrect");
        }
        else {
            log.info("User "+usertag+" has logged in successfully ");
            return user;
        }
    }

    //Logout Method

    public String logout(User user) {
        log.info("logout() invoked");
        log.info("User "+user.getUserTag()+" has been logged out");
        return "User "+user.getUserTag()+" has been logged out";
    }
}
