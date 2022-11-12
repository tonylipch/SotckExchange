package com.anton.lipchstock.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table (name = "stock")
public class Stock {
    @Id
    @Column(name = "STOCK_ID", nullable = false)
    private String stockId;


    @NotNull
    @Column (name = "STOCK_NAME")

    private String stockName;


    @NotNull
    @Column (name = "QUANTITY")
    private int quantity;

    @NotNull
    @Column(name = "STOCK_PRICE")
    private double stockPrice;

    @Transient
    @Column(name = "STOCK_TOTAL")
    private double stockTotal;

    @JsonIgnore
    @Column(name = "STATUS")
    private String status="active";

    @ManyToOne
    @JoinColumn(name = "company_id")
    @JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
    private Company company;

    @JsonIgnore
    @OneToMany(targetEntity = Transaction.class, mappedBy = "stock")
    private List<Transaction> transactions = new ArrayList<>();

}

