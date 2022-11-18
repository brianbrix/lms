package com.company.lms.model.res;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ScoreResponse {
    private Integer id;
    private String customerNumber;
    private Integer score;
    private Double limitAmount;
    private String exclusion;
    private String exclusionReason;
}
