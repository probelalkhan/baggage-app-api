package com.siemens.logistics.user_management.model.api_models.user;

import lombok.Data;

@Data
public class AddUserRequest {
    private String userName;
    private String emailId;
    private String firstName;
    private String lastName;
    private long mobile;
    private char active;
    private String userPassword;
}
