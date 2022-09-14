package com.example.demo.controllers.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterRequestDTO {
    private String email;
    private String role;
    private String password;
    private String firstName;
    private String lastName;
    
}
