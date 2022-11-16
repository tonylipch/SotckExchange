package com.anton.lipchstock.Entity;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Pattern;


import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name ="customer")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "USER_ID", updatable = false, nullable = false )
    private Long userId;


    @NotNull
    @Pattern(regexp = "(Admin|Investor|Manager)", message = "Role must be Admin , Investor or Manager")
    @Column(name = "ROLE")
    private  String role;

    @NotNull
    @Length(min = 5, max = 20, message =  "Username should be from 5 to 20 characters")
    @Pattern( regexp = "^[A-Za-z]+[A-Za-z_0-9]*$", message = "Username should not contain any special characters")
    @Column (name = "USER_TAG")
    private String userTag;

    @NotNull
    @Length(min = 8 , max = 20 , message = "Password should be from 8 to 20 characters")
    @Pattern(regexp = "[A-Za-z]+[0-9]+[!@#$%^&*]+", message = "Password should atleast contain a digit and a special character")
    @Column(name = "PASSWORD")
    private String password;


    @OneToOne
    BankAccount bankAccount ;


    @Override
    public String toString() {
        return "User [userId=" + userId + ", userTag=" + userTag + ", password=" + password + ", role=" + role + "]";
    }



}
