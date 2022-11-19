package com.anton.lipchstock.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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
