package com.OOPCwEx.ServiceBookingSystem.services.authentication;


import com.OOPCwEx.ServiceBookingSystem.dto.SignupRequestDTO;
import com.OOPCwEx.ServiceBookingSystem.dto.UserDto;
import com.OOPCwEx.ServiceBookingSystem.entity.User;
import com.OOPCwEx.ServiceBookingSystem.enums.UserRole;
import com.OOPCwEx.ServiceBookingSystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class AuthServiceImplementation implements AuthService {

    @Autowired
    private UserRepository userRepository;

    public UserDto signupClient(SignupRequestDTO signupRequestDTO){
        User user = new User();

        user.setFirstName(signupRequestDTO.getFirstName());
        user.setLastName(signupRequestDTO.getLastName());
        user.setEmail(signupRequestDTO.getEmail());
        user.setPhoneNumber(signupRequestDTO.getPhoneNumber());
        user.setPassword(signupRequestDTO.getPassword());

        user.setRole(UserRole.CLIENT);

        return userRepository.save(user).getDto();
    }

    public Boolean presentByEmail(String email){
        return userRepository.findFirstByEmail(email) !=null;
    }

    public UserDto signupCompany(SignupRequestDTO signupRequestDTO){
        User user = new User();

        user.setFirstName(signupRequestDTO.getFirstName());
        user.setEmail(signupRequestDTO.getEmail());
        user.setPhoneNumber(signupRequestDTO.getPhoneNumber());
        user.setPassword(signupRequestDTO.getPassword());

        user.setRole(UserRole.COMPANY);

        return userRepository.save(user).getDto();
    }
}

