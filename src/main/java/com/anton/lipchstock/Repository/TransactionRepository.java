package com.anton.lipchstock.Repository;

import com.anton.lipchstock.Entity.Operation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends CrudRepository<Operation, Integer> {
}
