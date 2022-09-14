package com.example.demo.services;
import org.springframework.http.HttpHeaders;

import java.util.Locale;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.security.authentication.AuthenticationManager;

import com.example.demo.controllers.dto.ChangePasswordDTO;
import com.example.demo.controllers.dto.GetUserRequestByEmail;
import com.example.demo.controllers.dto.LoginRequestDTO;
import com.example.demo.controllers.dto.LoginResponseDTO;
import com.example.demo.controllers.dto.RegisterRequestDTO;
import com.example.demo.entities.User;
import com.example.demo.repositories.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import com.example.demo.security.Role;
import com.example.demo.security.UserDetailsImplementation;


@Service
public class UserService {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    JWTService jwtHelper;


    /*
     *     Executa logica de login pe baza adresei de email si parolei
     * */
    public ResponseEntity<?> login(@RequestBody LoginRequestDTO loginRequest) {
        System.out.println(loginRequest.getEmail());
        System.out.println(loginRequest.getPassword());

        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        UserDetailsImplementation userDetails = (UserDetailsImplementation) authentication.getPrincipal();

        ResponseCookie jwtCookie = jwtHelper.generateJwtCookie(userDetails);

        String role = userDetails.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList()).get(0);

        return ResponseEntity.ok().header(HttpHeaders.SET_COOKIE, jwtCookie.toString())
                .body(new LoginResponseDTO(userDetails.getEmail(), role , userDetails.getId(),  jwtCookie.getValue()));
    }


    /*
     *     Executa logica de register pe baza adresei de email, a parolei si a tipului
     *     de utilizator ce trebuie creat (Administrator/ Author / Reader).
     * */
    @Transactional
    public ResponseEntity<?> register(@RequestBody RegisterRequestDTO registerRequestDTO) {
        if (userRepository.existsByEmail(registerRequestDTO.getEmail())) {
//            throw new RuntimeException("Email used");
            return ResponseEntity.badRequest().body("Email used");
        }

        String role = registerRequestDTO.getRole();
        // TODO: add more sanity checks (email, password, etc.)

        if (role == null || !(role.toUpperCase(Locale.ROOT).equals("USER") || role.toUpperCase(Locale.ROOT).equals("ADMIN"))) {
            throw new RuntimeException("Invalid role");
        }
        User user =  new User();
        if(role.equals("user")) {

            user.setEmail(registerRequestDTO.getEmail());
            user.setPassword(encoder.encode(registerRequestDTO.getPassword()));
            user.setRole(Role.USER);
//            user = new User(null, registerRequestDTO.getEmail(), encoder.encode(registerRequestDTO.getPassword()), Role.USER);
        

        
    }

    userRepository.save(user);
        return ResponseEntity.ok("User registered successfully!");
    }




    /*
    *     Permite modificarea adresei de email sau a parolei pentru un utilizator
     * */
    //TODO : pleae check it !
    public void changePasswordEmail(ChangePasswordDTO changePasswordDTO){

        if(!changePasswordDTO.getNewPassword().equals(changePasswordDTO.getConfirmNewpassword()))
            System.out.println("Please check the Confirmation Password !");

        User user = userRepository.findByEmail(changePasswordDTO.getEmail()).get();
        user.setPassword(changePasswordDTO.getNewPassword());

        userRepository.save(user);
    }


    public User getUserByEmail(GetUserRequestByEmail getUserRequestByEmail){
        return userRepository.findByEmail(getUserRequestByEmail.getEmail()).get();
    }

    public Optional<User> getUserById(Long id){
        return userRepository.findById(id);
    }


}