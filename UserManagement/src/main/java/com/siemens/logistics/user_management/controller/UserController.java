package com.siemens.logistics.user_management.controller;

import com.siemens.logistics.user_management.model.api_models.user.*;
import com.siemens.logistics.user_management.model.table_models.user.UserTable;
import com.siemens.logistics.user_management.services.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * This class is the controller class for user management and exposes API's for end users.
 */
@RestController
@RequestMapping("/userManagement")
public class UserController {

    @Autowired
    UserService userService;

    private static Logger logger = LogManager.getLogger(UserController.class);

    /**
     * This API is only for demonstration (Remove/update this request once dev starts)
     *
     * @return - All users
     */
    @GetMapping("/getAllUsers")
    public GetAllUsersResponse getAllUsers() {
        logger.info("Get all users request received");
        List<UserTable> listOfUsers = userService.getAllUsers();
        GetAllUsersResponseData data = new GetAllUsersResponseData(listOfUsers);
        return new GetAllUsersResponse(true, 200, 0, "Success", data);
    }


    /**
     * This API is only for demonstration (Remove/update  this request once dev starts)
     *
     * @return - error
     */
}
