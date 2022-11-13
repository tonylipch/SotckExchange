package com.anton.lipchstock.Repository;

import com.anton.lipchstock.Entity.BankAccount;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BankAccountRepository extends CrudRepository<BankAccount,String> {
}
