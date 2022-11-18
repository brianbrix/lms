package com.company.lms.model.req;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LoanRequest {
    private String customerNumber;
    private Double amount;
    private String status="NEW";
    public LoanRequest(String customerNumber, Double amount)
    {
        this.customerNumber= customerNumber;
        this.amount = amount;
    }
}
