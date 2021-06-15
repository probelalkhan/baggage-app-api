package com.siemens.logistics.user_management.model.table_models.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "USER_TABLE")
@NamedQuery(name = "UserTable.findAll", query = "SELECT b FROM UserTable b")
@Data
public class UserTable implements Serializable {

    @Id
    @Column(name = "USER_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ")
    @SequenceGenerator(name = "SEQ", sequenceName = "USER_SEQ")
    private long id;

    @Column(name = "USER_NAME")
    private String userName;

    @Column(name = "EMAIL_ID")
    private String email;

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "LAST_NAME")
    private String lastName;

    @Column(name = "USER_CODE")
    private String userCode;

    @Column(name = "MOBILE")
    private long mobile;

    @Column(name = "ACTIVE")
    private char active;

    @Column(name = "USER_PASSWORD")
    private String password;

    @JsonIgnore
    @Column(name = "CREATED_ON")
    private Date createdOn;

    @JsonIgnore
    @Column(name = "LAST_UPDATED")
    private Date lastUpdated;

}

