package com.anton.lipchstock.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor

@Data
@Table(name = "operation")
public class Operation {


    @Id
    @GeneratedValue
    private  int transactionId;


    private LocalDateTime transactionTime;

    private  String transactionType;



   private  int quantity;
}
