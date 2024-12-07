package com.OOPCwEx.ServiceBookingSystem.entity;

import com.OOPCwEx.ServiceBookingSystem.dto.UserDto;
import com.OOPCwEx.ServiceBookingSystem.enums.UserRole;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Users")
@Data

public class User {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long id;

    private String email;

    private String password;

    private String firstName;

    private String lastName;

    private String phoneNumber;

    private UserRole role;

    public UserDto getDto(){
        UserDto userDto = new UserDto();
        userDto.setId(id);
        userDto.setEmail(email);
        userDto.setFirstName(firstName);
        userDto.setLastName(lastName);

        return userDto;
    }
}
