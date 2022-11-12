package com.anton.lipchstock.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

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


   @ManyToOne
   @JoinColumn(name = "stockId")
    private Stock stock;

   @ManyToOne
   @JoinColumn(name = "investorId")
   private Investor investor;

   private  int quantity;
}
