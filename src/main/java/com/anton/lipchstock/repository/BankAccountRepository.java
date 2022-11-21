package com.anton.lipchstock.repository;

import com.anton.lipchstock.entity.BankAccount;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BankAccountRepository extends CrudRepository<BankAccount,String> {
}
