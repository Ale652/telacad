package com.example.demo.controllers.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginResponseDTO {
    
    private Long id;
    private String email;
    private String role;
    private String token;

    
    public LoginResponseDTO( String email, String role,Long id, String token) {
        this.id = id;
        this.email = email;
        this.role = role;
        this.token = token;
    }
    

}
