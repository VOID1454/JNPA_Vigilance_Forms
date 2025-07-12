package com.example.useradminauth.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.useradminauth.model.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
    Object findByStaffNo = null;
    
    Optional<User> findByEmailAndPassword(String email, String password);
    Optional<User> findByStaffno(String staffno);
//    User findByusername(String email);
}
