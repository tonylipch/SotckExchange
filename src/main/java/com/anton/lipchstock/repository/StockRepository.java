package com.anton.lipchstock.repository;

import com.anton.lipchstock.entity.Stock;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StockRepository extends CrudRepository <Stock, String> {
}
