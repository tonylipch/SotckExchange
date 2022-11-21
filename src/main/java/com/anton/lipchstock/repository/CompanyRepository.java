package com.anton.lipchstock.repository;

import com.anton.lipchstock.entity.Company;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends CrudRepository<Company,String> {
}
