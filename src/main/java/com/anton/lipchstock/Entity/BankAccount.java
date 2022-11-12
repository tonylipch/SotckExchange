package com.anton.lipchstock.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Pattern;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table (name ="bank_account")
public class BankAccount {
    @Id
    @Column(name = "ACCOUNT_NO", nullable = false, updatable = false)
    private String accountNo;


    @NotNull
    @Column(name = "BANK_NAME")
    private String bankName;


    @NotNull
    @Column(name = "BRANCH_NAME" )
    private String branchName;

    @NotNull
    @Pattern(regexp = "^[A-Z]+[0-9]+")
    @Column(name = "IFSC_CODE")
    private String ifscCode;

    @JsonIgnore
    @OneToOne(mappedBy = "account")
    private Investor investor;

}
