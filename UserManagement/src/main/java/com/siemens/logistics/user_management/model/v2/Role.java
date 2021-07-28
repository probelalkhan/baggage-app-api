package com.siemens.logistics.user_management.model.v2;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "roles")
@Data
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ")
    @SequenceGenerator(name = "SEQ", sequenceName = "ROLE_SEQ")
    private long id;
    private String name;
    private boolean active;
    private Date createdOn;
    private Date lastUpdated;
}
