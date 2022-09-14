package com.example.demo.controllers.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ChangePasswordDTO {
    private String email;
    private String password;
    private String newPassword;
    private String confirmNewpassword;
}
