package com.anton.lipchstock.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Operation extends CrudRepository<com.anton.lipchstock.Entity.Operation, Integer> {
}
