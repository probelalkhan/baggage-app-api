package com.siemens.logistics.user_management.model.table_models.user;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "USER_ROLE_MAPPING")
@NamedQuery(name = "UserRoleMappingTable.findAll", query = "SELECT b FROM UserRoleMappingTable b")
@Data
public class UserRoleMappingTable {
    @Id
    @Column(name = "ID")
    private Long id;

    @Column(name = "USER_ID")
    private Long userId;

    @Column(name = "ROLE_ID")
    private Long roleId;
}
