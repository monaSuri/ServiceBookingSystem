package com.OOPCwEx.ServiceBookingSystem.dto;


import lombok.Data;

@Data

public class SignupRequestDTO {

    private long id;

    private String email;

    private String password;

    private String firstName;

    private String lastName;

    private String phoneNumber;

}
