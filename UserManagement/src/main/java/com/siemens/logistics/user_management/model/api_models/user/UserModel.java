package com.siemens.logistics.user_management.model.api_models.user;

import com.siemens.logistics.user_management.model.table_models.user.RoleTable;
import lombok.Data;

import java.util.List;

@Data
public class UserModel {
    private long id;
    private String userName;
    private String email;
    private String firstName;
    private String lastName;
    private String userCode;
    private long mobile;
    private char active;
    private String password;
    private List<RoleTable> roles;
}
