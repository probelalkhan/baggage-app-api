package com.siemens.logistics.user_management.model.api_models.user;

import com.siemens.logistics.user_management.model.table_models.user.UserTable;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data @AllArgsConstructor
public class GetAllUsersResponseData{
    private List<UserTable> users;
}
