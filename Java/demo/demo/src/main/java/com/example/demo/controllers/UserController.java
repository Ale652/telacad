package com.example.demo.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.controllers.dto.GetUserRequestByEmail;
import com.example.demo.controllers.dto.LoginRequestDTO;
import com.example.demo.controllers.dto.RegisterRequestDTO;
import com.example.demo.entities.User;
import com.example.demo.services.UserService;


@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserController {
    
    @Autowired
    private UserService userService;


    @PostMapping("/login")
    public ResponseEntity<?> login(@Valid @RequestBody LoginRequestDTO loginRequest) {
        return userService.login(loginRequest);
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@Valid @RequestBody RegisterRequestDTO registerRequestDTO) {
        return userService.register(registerRequestDTO);
    }


    @PostMapping(path="/getUserByEmail")
    public User getReaderByEmail(@RequestBody GetUserRequestByEmail getUserRequestByEmail){
        return userService.getUserByEmail(getUserRequestByEmail);
    }


    @GetMapping(path = "/{id}")
    public @ResponseBody
    User getAuthor(@PathVariable String id) {
        return userService.getUserById(Long.valueOf(id)).get();
    }


}
