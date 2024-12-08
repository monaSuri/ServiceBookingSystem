package com.OOPCwEx.ServiceBookingSystem.services.authentication;

import com.OOPCwEx.ServiceBookingSystem.dto.SignupRequestDTO;
import com.OOPCwEx.ServiceBookingSystem.dto.UserDto;

public interface AuthService {
    UserDto signupClient(SignupRequestDTO signupRequestDTO);

    Boolean presentByEmail(String email);
}
