package com.company.lms.model.res;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GenericResponse <T>{
    private String status;
    private String message;
    private T data;
    public GenericResponse(String status, T data)
    {
        this.status=status;
        this.data=data;
    }
}
