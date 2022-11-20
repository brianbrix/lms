package com.company.lms.db;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.relational.core.mapping.Table;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Date;

@Entity
@Table(name = "customer_kyc")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class CustomerKYC {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long recordId;
    private String createdAt;
    private String createdDate;
    private String customerNumber;
    private String email;
    private String firstName;
    private String gender;
    private int id;
    private Long idNumber;
    private String idType;
    private String lastName;
    private String middleName;
    private String mobile;
    private Double monthlyIncome;
    private String status;
    private String updatedAt;
}
