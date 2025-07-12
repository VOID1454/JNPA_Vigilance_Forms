package com.example.forms.repository;

import com.example.forms.model.PasswordHistory;
import com.example.forms.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface PasswordHistoryRepository extends JpaRepository<PasswordHistory, Long> {
    List<PasswordHistory> findTop5ByUserOrderByChangedAtDesc(User user);
}
