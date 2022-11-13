package com.anton.lipchstock.Repository;

import com.anton.lipchstock.Entity.Stock;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StockRepository extends CrudRepository <Stock, String> {
}
