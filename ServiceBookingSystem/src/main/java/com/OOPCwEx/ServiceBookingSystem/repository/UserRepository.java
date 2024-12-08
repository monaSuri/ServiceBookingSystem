package com.OOPCwEx.ServiceBookingSystem.repository;

import java.util.Optional;
import com.OOPCwEx.ServiceBookingSystem.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface UserRepository extends JpaRepository<User, Long> {
    Optional <User> findFirstByEmail(String email);
}