package com.anton.lipchstock.repository;

import com.anton.lipchstock.entity.Manager;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ManagerRepository extends CrudRepository<Manager,String> {
}
