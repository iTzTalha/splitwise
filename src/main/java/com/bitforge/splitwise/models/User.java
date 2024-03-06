package com.bitforge.splitwise.models;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Entity(name = "users")
@Data
public class User extends BaseModel {
    private String name;
    private String contact;
    private String password;
}
