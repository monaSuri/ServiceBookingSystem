package com.OOPCwEx.ServiceBookingSystem.controller;

import com.OOPCwEx.ServiceBookingSystem.dto.SignupRequestDTO;
import com.OOPCwEx.ServiceBookingSystem.dto.UserDto;
import com.OOPCwEx.ServiceBookingSystem.services.authentication.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api") // Added base path for consistency
public class AuthenticationController {

    @Autowired
    private AuthService authService;

    @PostMapping("/client/sign-up") // Changed to POST as it aligns with resource creation
    public ResponseEntity<?> signupClient(@RequestBody SignupRequestDTO signupRequestDTO) {

        System.out.println("SignupRequestDTO class: " + SignupRequestDTO.class);

        if (authService.presentByEmail(signupRequestDTO.getEmail())) {
            return new ResponseEntity<>("Client already exists with this Email!", HttpStatus.NOT_ACCEPTABLE);
        }

        UserDto createdUser = authService.signupClient(signupRequestDTO);
        return new ResponseEntity<>(createdUser, HttpStatus.OK);
    }

    @PostMapping("/company/sign-up") // Changed to POST for consistency
    public ResponseEntity<?> signupCompany(@RequestBody SignupRequestDTO signupRequestDTO) {

        System.out.println("SignupRequestDTO class: " + SignupRequestDTO.class);

        if (authService.presentByEmail(signupRequestDTO.getEmail())) {
            return new ResponseEntity<>("Company already exists with this Email!", HttpStatus.NOT_ACCEPTABLE);
        }

        UserDto createdUser = authService.signupClient(signupRequestDTO);
        return new ResponseEntity<>(createdUser, HttpStatus.OK);
    }
}