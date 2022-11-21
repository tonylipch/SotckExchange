package com.anton.lipchstock.repository;

import com.anton.lipchstock.entity.Investor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvestorRepository extends CrudRepository<Investor,String> {
}
