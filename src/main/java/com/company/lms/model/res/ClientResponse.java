package com.company.lms.model.res;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ClientResponse {
    private int id;
    private String url;
    private String name;
    private String username;
    private String password;
    private String token;
}
