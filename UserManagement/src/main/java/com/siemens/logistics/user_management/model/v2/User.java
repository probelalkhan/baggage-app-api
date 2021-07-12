package com.siemens.logistics.user_management.model.v2;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "Users")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ")
    @SequenceGenerator(name = "SEQ", sequenceName = "USER_SEQ1")
    private long id;
    private String name;
    private String description;
    private String department;
    private Long role_id;
    private String password;
    private Date password_expires_on;
    private boolean locked;
    private Date account_expires_on;

    public User(long id, String name, String description, String department, long role_id, String password, Date password_expires_on, boolean locked, Date account_expires_on) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.department = department;
        this.role_id = role_id;
        this.password = password;
        this.password_expires_on = password_expires_on;
        this.locked = locked;
        this.account_expires_on = account_expires_on;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getDepartment() {
        return department;
    }

    public long getRole_id() {
        return role_id;
    }

    public String getPassword() {
        return password;
    }

    public Date getPassword_expires_on() {
        return password_expires_on;
    }

    public boolean isLocked() {
        return locked;
    }

    public Date getAccount_expires_on() {
        return account_expires_on;
    }

}