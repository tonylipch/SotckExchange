package com.anton.lipchstock.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Operation extends CrudRepository<com.anton.lipchstock.entity.Operation, Integer> {
}
