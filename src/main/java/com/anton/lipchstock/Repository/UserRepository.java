package com.anton.lipchstock.Repository;

import com.anton.lipchstock.Entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository  extends CrudRepository<User,Long> {
    public User findByUserTagAndPassword(String userTag, String password);

    public User findByPassword(String password);
}
