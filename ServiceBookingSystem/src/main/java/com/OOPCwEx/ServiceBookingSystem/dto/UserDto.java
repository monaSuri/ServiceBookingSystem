package com.OOPCwEx.ServiceBookingSystem.dto;

import com.OOPCwEx.ServiceBookingSystem.enums.UserRole;
import lombok.Data;

@Data

public class UserDto {

    private long id;

    private String email;

    private String password;

    private String firstName;

    private String lastName;

    private String phoneNumber;

    private UserRole role;

}
