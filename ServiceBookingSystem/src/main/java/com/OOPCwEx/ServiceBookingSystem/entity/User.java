package com.OOPCwEx.ServiceBookingSystem.entity;

import com.OOPCwEx.ServiceBookingSystem.dto.UserDto;
import com.OOPCwEx.ServiceBookingSystem.enums.UserRole;
import jakarta.persistence.*;

@Entity
@Table(name = "Users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private String phoneNumber;

    @Enumerated(EnumType.STRING)
    private UserRole role;

    // Getters and Setters for all fields (omitted here for brevity)

    // Method to convert User to UserDto
    public UserDto getDto() {
        return null;
    }

    public void setFirstName(String firstName) {
    }

    public void setLastName(String lastName) {
    }

    public void setEmail(String email) {
    }

    public void setPhoneNumber(String phoneNumber) {
    }

    public void setPassword(String password) {
    }

    public void setRole(UserRole userRole) {
    }
}