package com.bitforge.splitwise.services;

import com.bitforge.splitwise.enums.SettleUpStrategyType;
import com.bitforge.splitwise.exceptions.GroupNotFoundException;
import com.bitforge.splitwise.exceptions.UserNotFoundException;
import com.bitforge.splitwise.factories.SettleUpHeapStrategyFactory;
import com.bitforge.splitwise.models.Expense;
import com.bitforge.splitwise.models.ExpenseUser;
import com.bitforge.splitwise.models.Group;
import com.bitforge.splitwise.models.User;
import com.bitforge.splitwise.repositories.ExpenseRepository;
import com.bitforge.splitwise.repositories.ExpenseUserRepository;
import com.bitforge.splitwise.repositories.GroupRepository;
import com.bitforge.splitwise.repositories.UserRepository;
import com.bitforge.splitwise.strategies.SettleUpStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class SettleUpService {
    private final UserRepository userRepository;
    private final ExpenseUserRepository expenseUserRepository;
    private final GroupRepository groupRepository;
    private final ExpenseRepository expenseRepository;

    @Autowired
    public SettleUpService(UserRepository userRepository, ExpenseUserRepository expenseUserRepository, GroupRepository groupRepository, ExpenseRepository expenseRepository) {
        this.userRepository = userRepository;
        this.expenseUserRepository = expenseUserRepository;
        this.groupRepository = groupRepository;
        this.expenseRepository = expenseRepository;
    }

    public List<Expense> settleUpUser(Long userId) throws UserNotFoundException {
        Optional<User> userOptional = userRepository.findById(userId);
        if (userOptional.isEmpty()) {
            throw new UserNotFoundException();
        }
        User user = userOptional.get();

        List<ExpenseUser> expenseUsers = expenseUserRepository.findAllByUser(user);

        Set<Expense> uniqueExpenseSet = new HashSet<>();
        for (ExpenseUser expenseUser : expenseUsers) {
            uniqueExpenseSet.add(expenseUser.getExpense());
        }

        List<Expense> uniqueExpenses = uniqueExpenseSet.stream().toList();

        SettleUpStrategy heapStrategy = SettleUpHeapStrategyFactory
                .getSettleUpStrategyByType(SettleUpStrategyType.HEAP);

        return heapStrategy.settleUp(uniqueExpenses);
    }

    public List<Expense> settleUpGroup(Long groupId) throws GroupNotFoundException {
        Optional<Group> groupOptional = groupRepository.findById(groupId);
        if (groupOptional.isEmpty()) {
            throw new GroupNotFoundException();
        }
        Group group = groupOptional.get();

        List<Expense> expensesToCompute = expenseRepository.findAllByGroup(group);

        SettleUpStrategy heapStrategy = SettleUpHeapStrategyFactory
                .getSettleUpStrategyByType(SettleUpStrategyType.HEAP);

        return heapStrategy.settleUp(expensesToCompute);
    }
}