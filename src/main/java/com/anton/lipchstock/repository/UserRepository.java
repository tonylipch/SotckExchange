package com.anton.lipchstock.repository;

import com.anton.lipchstock.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository  extends CrudRepository<User,Long> {
    public User findByUserTagAndPassword(String userTag, String password);

    public User findByPassword(String password);

    public Optional<User> findByUserTag(String login);
}
