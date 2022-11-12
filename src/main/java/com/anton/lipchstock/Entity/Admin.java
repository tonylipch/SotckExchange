package com.anton.lipchstock.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "admin")
public class Admin {

   @Id
   @Column(name = "ADMIN_ID", updatable = false, nullable = false)
    private String adminId;


    @NotNull
    @Pattern(regexp = "[A-Za-z\\s]+", message = "Admin name is not valid")
    @Length(min = 5, max = 20, message = "Admin name should be 5 to 25 characters")
    @Column(name = "ADMIN_NAME")
    private String adminName;

    @NotNull
    @Pattern(regexp = "^[A-Za-z0-9._]+@[A-za-z0-9]+[.][A-za-z]{2,5}$", message = "Email is not valid")
    @Column(name = "EMAIL")
    private String email;

    @NotNull
    @Pattern(regexp = "[A-Za-z]+[0-9]+[!@#$%^&*]+", message = "Password should atleast contain a digit and a special character")
    @Length(min = 7, max = 20, message = "Password should be 7 to 20 characters")
    @Column(name = "PASSWORD")
    private String password;


    @Override
    public String toString() {
        return "Admin [adminId=" + adminId + ", adminName=" + adminName + ", email=" + email + ", password=" + password
                + "]";
    }

}
