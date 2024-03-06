package com.bitforge.splitwise.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity(name = "userGroups")
@Data
public class Group extends BaseModel {
    private String name;
    @ManyToMany
    private List<User> members;
    @OneToMany
    private List<Expense> expenses;
    @ManyToOne
    private User createdBy;
}
