package com.siemens.logistics.user_management.controller;

import com.siemens.logistics.user_management.model.api_models.user.*;
import com.siemens.logistics.user_management.model.table_models.user.UserTable;
import com.siemens.logistics.user_management.model.v2.User;
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
}
