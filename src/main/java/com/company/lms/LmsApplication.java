package com.company.lms;

import com.company.lms.db.repos.KYCRepository;
import com.company.lms.db.repos.LoanRequestRepository;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Loan Management System", version = "1.0", description = "Documentation APIs v1.0"))
@EnableR2dbcRepositories(basePackageClasses = {KYCRepository.class, LoanRequestRepository.class})
public class LmsApplication {

    public static void main(String[] args) {
        SpringApplication.run(LmsApplication.class, args);
    }

}
