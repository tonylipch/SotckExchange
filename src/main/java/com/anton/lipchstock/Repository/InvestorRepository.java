package com.anton.lipchstock.Repository;

import com.anton.lipchstock.Entity.Investor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvestorRepository extends CrudRepository<Investor,String> {
}
