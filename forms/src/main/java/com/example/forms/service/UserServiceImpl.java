package com.example.forms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.forms.model.PasswordHistory;
import com.example.forms.model.User;
import com.example.forms.repository.PasswordHistoryRepository;
import com.example.forms.repository.UserRepository;
;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

      @Autowired
    private PasswordHistoryRepository passwordHistoryRepository;

    


    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void saveUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword())); // Encrypt password
        userRepository.save(user);
    }
    

    @Override
    public void saveAllUsers(List<User> users) {
        for (User user : users) {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
        }
        userRepository.saveAll(users);
    }


    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email).orElse(null);
    }
    
    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }


    


    @Override
    public String changePassword(Long userId, String oldPassword, String newPassword) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        // Validate old password
        if (!passwordEncoder.matches(oldPassword, user.getPassword())) {
            return "Old password is incorrect!";
        }

        // Fetch last 5 passwords
        List<PasswordHistory> passwordHistories = passwordHistoryRepository.findTop5ByUserOrderByChangedAtDesc(user);

        // Check if new password matches any of the last 5 used passwords
        for (PasswordHistory history : passwordHistories) {
            if (passwordEncoder.matches(newPassword, history.getPasswordHash())) {
                return  "New password must not be the same as the last 5 passwords!";
            }
        }

        // Hash the new password and update user record
        String hashedNewPassword = passwordEncoder.encode(newPassword);
        user.setPassword(hashedNewPassword);
        userRepository.save(user);

        // Save old password in history
        PasswordHistory history = new PasswordHistory();
        history.setUser(user);
        history.setPasswordHash(hashedNewPassword);
        passwordHistoryRepository.save(history);


        // If the user has more than 5 passwords in history, delete the oldest one
    if (passwordHistories.size() >= 5) {
        PasswordHistory oldestPassword = passwordHistories.get(passwordHistories.size() - 1);
        passwordHistoryRepository.delete(oldestPassword);
    }

    return "Password changed successfully!";
        

        

    }

    

    }


