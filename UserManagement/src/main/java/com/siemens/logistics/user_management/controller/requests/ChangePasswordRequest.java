package com.siemens.logistics.user_management.controller.requests;

import lombok.Data;

@Data
public class ChangePasswordRequest {
    long id;
    String newPassword;
}
