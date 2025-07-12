package com.example.forms.service;

import java.util.List;

import com.example.forms.model.User;
public interface UserService {
    void saveUser(User user);
    User findByEmail(String email);
    void saveAllUsers(List<User> users);
	List<User> getAllUsers();
    
    


    String changePassword(Long userId, String oldPassword, String newPassword);


   


}

