package com.siemens.logistics.user_management.model.table_models.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "ROLE_TABLE")
@NamedQuery(name = "RoleTable.findAll", query = "SELECT b FROM RoleTable b")
@Data
public class RoleTable {
    @Id
    @Column(name = "ROLE_ID")
    private Long id;

    @Column(name = "ROLE_NAME")
    private String name;

    @Column(name = "ACTIVE")
    private char active;

    @JsonIgnore
    @Column(name = "CREATED_ON")
    private Date createdOn;

    @JsonIgnore
    @Column(name = "LAST_UPDATED")
    private Date lastUpdated;
}
