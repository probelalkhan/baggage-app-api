package com.siemens.logistics.user_management.model.v2;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "Groups")
@Data
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ")
    @SequenceGenerator(name = "SEQ", sequenceName = "GROUP_SEQ1")
    private long id;
    private String name;
    private String description;
    private boolean locked;
    private long session_timeout;


    public Group(long id, String name, String description, boolean locked, long session_timeout) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.locked = locked;
        this.session_timeout = session_timeout;
    }

    public Group() {

    }

    public long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public boolean isLocked() {
        return locked;
    }

    public long getSessionTimeout() {
        return session_timeout;
    }
}
