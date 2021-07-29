package com.siemens.logistics.user_management.controller.requests;

import lombok.Data;

@Data
public class ChangePasswordRequest {
    String name;
    String newPassword;
}
