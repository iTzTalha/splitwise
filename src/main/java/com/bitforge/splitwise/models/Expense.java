package com.bitforge.splitwise.models;

import com.bitforge.splitwise.enums.ExpenseType;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity(name = "expenses")
@Data
public class Expense extends BaseModel {
    private String description;
    private double amount;
    @ManyToOne
    private User createdBy;
    @Enumerated(EnumType.ORDINAL)
    private ExpenseType expenseType;
    @ManyToOne
    private Group group;
    @OneToMany
    private List<ExpenseUser> expenseUsers;
}