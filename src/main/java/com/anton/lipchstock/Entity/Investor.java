package com.anton.lipchstock.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="investor")
@Data

public class Investor {

    @Id
    @Column(name = "INVESTOR_ID")
    private String investorId;

    @NotNull
    @Length(min = 5, max = 20, message = "Username should be from 5 to 20 characters")
    @Column(name = "INVESTOR_NAME")
    private String investorName;

    @Pattern(regexp = "^[A-Za-z0-9._]+@[A-za-z0-9]+[.][A-za-z]{2,5}$", message = "Email is not valid")
    @Column(name = "EMAIL")
    private String email;

    @NotNull
    @Pattern(regexp = "[A-Za-z]+[0-9]+[!@#$%^&*]+", message = "Password should atleast contain a digit and a special character")
    @Length(min = 7, max = 20, message = "Username should be from 7 to 20 characters")
    @Column(name = "PASSWORD")
    private String password;

    @NotNull
    @Pattern(regexp = "[0-9]{10}", message = "Invalid Mobile number")
    @Column(name = "MOBILE_NO")
    private String mobileNo;

    @Pattern(regexp = "(male|female)", message = "Invalid Gender")
    @Column(name = "GENDER")
    private String gender;

    @JsonIgnore
    @Column(name = "STATUS")
    private String status = "pending"; // approved or pending


}
