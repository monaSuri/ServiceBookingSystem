package com.OOPCwEx.ServiceBookingSystem.controller;

import com.OOPCwEx.ServiceBookingSystem.dto.SignupRequestDTO;
import com.OOPCwEx.ServiceBookingSystem.dto.UserDto;
import com.OOPCwEx.ServiceBookingSystem.services.authentication.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth") // Base path for all authentication-related endpoints
public class AuthenticationController {

    @Autowired
    private AuthService authService;

    /**
     * Endpoint to handle client sign-up requests.
     *
     * @param signupRequestDTO the client sign-up request details
     * @return ResponseEntity with success or error message
     */
    @PostMapping("/client/sign-up")
    public ResponseEntity<?> signupClient(@RequestBody SignupRequestDTO signupRequestDTO) {
        if (authService.presentByEmail(signupRequestDTO.getEmail())) {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body("Client already exists with this Email!");
        }

        UserDto createdUser = authService.signupClient(signupRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
    }

    /**
     * Endpoint to handle company sign-up requests.
     *
     * @param signupRequestDTO the company sign-up request details
     * @return ResponseEntity with success or error message
     */
    @PostMapping("/company/sign-up")
    public ResponseEntity<?> signupCompany(@RequestBody SignupRequestDTO signupRequestDTO) {
        if (authService.presentByEmail(signupRequestDTO.getEmail())) {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body("Company already exists with this Email!");
        }

        UserDto createdUser = authService.signupCompany(signupRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
    }

    /**
     * Global exception handler for any unhandled exceptions.
     *
     * @param ex the exception
     * @return ResponseEntity with error message
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleExceptions(Exception ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("An unexpected error occurred: " + ex.getMessage());
    }
}