package com.siemens.logistics.user_management.model.v2;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "User_Group")
@Data
public class UserGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ")
    @SequenceGenerator(name = "SEQ", sequenceName = "GROUP_SEQ1")
    private long id;
    private long user_id;
    private long group_id;

    public UserGroup(long id, long user_id, long group_id) {
        this.id = id;
        this.user_id = user_id;
        this.group_id = group_id;
    }

    public long getId() {
        return id;
    }

    public long getUser_id() {
        return user_id;
    }

    public long getGroup_id() {
        return group_id;
    }
}
