

package com.example.forms.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.forms.model.User;


public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
    Object findByStaffNo = null;
    
    Optional<User> findByEmailAndPassword(String email, String password);
    Optional<User> findByStaffno(String staffno);
    Optional<User> findByDepartment(String department);
    
    @Query
    ("SELECT u FROM User u WHERE u.email = :email")
    public User findbyemailUser(String email);
}
