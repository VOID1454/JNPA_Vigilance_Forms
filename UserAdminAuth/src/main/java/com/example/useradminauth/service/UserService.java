package com.example.useradminauth.service;

import com.example.useradminauth.model.User;

public interface UserService {
    void saveUser(User user);
    User findByEmail(String email);
}
