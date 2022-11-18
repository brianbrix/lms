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

@Table(name = "loan_requests")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class LoanRequestEntity {
    @Id
    @org.springframework.data.annotation.Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String customerNumber;
    private Double amount;
    private String status;


}
