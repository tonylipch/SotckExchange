package com.anton.lipchstock.Service;

import com.anton.lipchstock.Entity.User;
import com.anton.lipchstock.Repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private  final UserRepository repo;


    @Autowired
    public UserService(UserRepository userRepository) {
        this.repo = userRepository;
    }


    Logger log = LoggerFactory.getLogger(UserService.class);


    public boolean addUser(User user) throws Exception {

        log.info("method :'Add user' has been invoked");

        if(repo.existsById(user.getUserId())){
            log.warn("This user already exists !");

            throw new Exception("User"+user.getUserTag()+"with id "+user.getUserId()+" already exists");

        }else{
            repo.save(user);
            log.info("User added");

            return true;
        }
    }

    public boolean deleteUser (User user)throws  Exception{

        log.info("method : 'Remove user' has been invoked");
        if (repo.existsById(user.getUserId())){
            repo.deleteById(user.getUserId());

            log.info ("User with tag: "+user.getUserTag()+"\n User id: "+user.getUserId()+" has been removed");
            return true;
        }
        log.warn("User with id : "+user.getUserId() +" not found");

        throw new Exception("User not found with id "+user.getUserId());

    }

    public boolean updateUser (User user) throws Exception {
        log.info("method: 'Update user' has been invoked");

        if (repo.existsById(user.getUserId())){
            repo.save(user);
            log.info("User with id "+user.getUserId()+" updated");
            return true;
        }
        log.warn("UserNotFoundException thrown...Delete Failed, User not found with id "+user.getUserTag());
        throw new Exception("User not found with id "+user.getUserId());

    }



}
