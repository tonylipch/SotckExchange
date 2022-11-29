package com.anton.lipchstock.service;



import com.anton.lipchstock.dto.NewUserDto;
import com.anton.lipchstock.dto.UserDto;
import com.anton.lipchstock.entity.User;
import com.anton.lipchstock.exceptions.BadRequestRuntimeException;

import com.anton.lipchstock.repository.UserRepository;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
//        user.setUserTag(userDto.getLogin());
//        user.setPassword(userDto.getPassword());
//        user = userRepository.save(user);

        return toDto(user);


    }

    private  UserDto toDto (User user){
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        UserDto dto = new UserDto();
        user = mapper.convertValue(dto,User.class);
        dto = mapper.convertValue(user, UserDto.class);
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

    public UserDto updateUser (UserDto updUser, Long id) throws Exception {
        log.info("method: 'Update user' has been invoked");
        Optional<User> currentUser = userRepository.findById(id);

        if (userRepository.existsById(updUser.getId())){

            User user = currentUser.get();
            user.setUserId(updUser.getId());
            user.setUserTag(updUser.getLogin());
            user.setPassword(updUser.getPassword());

            log.info("User with id "+updUser.getId()+" updated");
            return toDto(user);
        }
        log.warn("UserNotFoundException thrown...Delete Failed, User not found with id "+updUser.getId());
        throw new Exception("User not found with id "+updUser.getId());

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
