package com.bitforge.splitwise.repositories;

import com.bitforge.splitwise.models.ExpenseUser;
import com.bitforge.splitwise.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExpenseUserRepository extends JpaRepository<ExpenseUser, Long> {
    List<ExpenseUser> findAllByUser(User user);
}
