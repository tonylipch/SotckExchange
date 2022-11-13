package com.anton.lipchstock.Repository;

import com.anton.lipchstock.Entity.Company;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends CrudRepository<Company,String> {
}
