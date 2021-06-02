package com.siemens.logistics.user_management.controller;

import com.siemens.logistics.user_management.model.api_models.user.AddUserRequest;
import com.siemens.logistics.user_management.model.api_models.user.GetUserResponse;
import com.siemens.logistics.user_management.model.api_models.user.UserModel;
import com.siemens.logistics.user_management.model.table_models.user.UserTable;
import com.siemens.logistics.user_management.services.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * IMPORTANT INFO -This controller exposes only those API's that are accessed by the API gateway.
 */
@RestController
@RequestMapping("/api-gateway-request")
public class GatewayController {

    private static Logger logger = LogManager.getLogger(UserController.class);

    @Autowired
    UserService userService;

    /**
     * This API return user details. This API-revels the password of the user in hashed form, hence it is hidden from
     * end users
     *
     * @param username - Pass the username here
     * @return - User details response
     */
    @GetMapping("/getUser/{username}")
    public GetUserResponse getUser(@PathVariable("username") String username) {
        logger.debug("Get user details request received");
        UserModel user = userService.getUser(username);
        return new GetUserResponse(true, 200, 0, "Success", user);
    }

    @PostMapping("/adduser")
    public UserTable addUser(AddUserRequest request) {
        return userService.addUser(request);
    }

    @GetMapping("/users")
    public List<UserTable> getUsers() {
        return userService.getAllUsers();
    }
}
