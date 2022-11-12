package com.anton.lipchstock.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "company")
public class Company {

   @Id
   @Column(name = "COMPANY_NAME" , nullable = false)
    private String companyId;


   @Column(name = "COMPANY_NAME")
   @Length(min = 3 , max =  20)
   private String companyName;


    @Override
    public String toString() {
        return "Company [companyId=" + companyId + ", companyName=" + companyName + "]";
    }



}
