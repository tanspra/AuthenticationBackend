package com.auth.controller;

import com.auth.dto.LoginResponseDTO;
import com.auth.dto.RegistrationDTO;
import com.auth.models.ApplicationUser;
import com.auth.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@CrossOrigin("*")
public class AuthenticationController {
    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping("/register")
    public ApplicationUser registerSUer(@RequestBody RegistrationDTO dto){
        return authenticationService.registerUser(dto.getUsername(),dto.getPassword());
    }

    @PostMapping("/login")
    public LoginResponseDTO loginUser(@RequestBody RegistrationDTO dto){
        return authenticationService.loginUser(dto.getUsername(),dto.getPassword());
    }
}
