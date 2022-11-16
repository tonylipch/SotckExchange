package com.anton.lipchstock.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor

@Data
@Table(name = "transaction")
public class Transaction {


    @Id
    @GeneratedValue
    private  int transactionId;


    private LocalDateTime transactionTime;

    private  String transactionType;


   @OneToMany

    private List<Stock> stock = new ArrayList<>();

   @OneToMany
   private  List<BankAccount> bankAccounts = new ArrayList<>();



   private  int quantity;
}
