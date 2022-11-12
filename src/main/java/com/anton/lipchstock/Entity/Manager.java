package com.anton.lipchstock.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity
@AllArgsConstructor
@NoArgsConstructor

@Data
@Table(name = "manager")
public class Manager {

    @Id
    @Column(name = "MANAGER_ID", nullable = false)
    private String managerId;


    @NotNull
    @Column(name = "MANAGER_NAME")
    @Length(min =5 , max = 20, message = "Username should be from 5 to 20 characters")
    private String managerName;


    @NotNull
    @Pattern(regexp = "^[A-Za-z0-9._]+@[A-za-z0-9]+[.][A-za-z]{2,5}$", message = "Email is not valid")
    @Column(name = "EMAIL")
    private String email;

    @com.sun.istack.NotNull
    @Pattern(regexp = "[A-Za-z]+[0-9]+[!@#$%^&*]+", message = "Password should atleast contain a digit and a special character")
    @Length(min = 7, max = 20, message = "Username should be from 7 to 20 characters")
    @Column(name = "PASSWORD")
    private String password;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "companyId")
    @JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
    private Company company;


}
