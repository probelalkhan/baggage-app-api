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
    private Long group_id;
    private String password;
    private String password_expires_on;
    private boolean locked;
    private String account_expires_on;
}