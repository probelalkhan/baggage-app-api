package com.siemens.logistics.user_management.controller;

import com.siemens.logistics.user_management.controller.requests.ChangePasswordRequest;
import com.siemens.logistics.user_management.model.api_models.user.GetUserResponse;
import com.siemens.logistics.user_management.model.api_models.user.UserModel;
import com.siemens.logistics.user_management.model.table_models.user.UserTable;
import com.siemens.logistics.user_management.model.v2.Group;
import com.siemens.logistics.user_management.model.v2.Role;
import com.siemens.logistics.user_management.model.v2.User;
import com.siemens.logistics.user_management.services.UserService;
import com.siemens.logistics.user_management.services.v2.NewUserManagementService;
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

    @Autowired
    NewUserManagementService newUserManagementService;

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
        User user = newUserManagementService.getUser(username);
        return new GetUserResponse(true, 200, 0, "Success", user);
    }

    @PostMapping("/adduser")
    public User addUser(@RequestBody User request) {
        logger.debug("Add user details request received");
        return newUserManagementService.addUser(request);
    }

    @PostMapping("/updatepassword")
    public User updatePassword(@RequestBody ChangePasswordRequest request) {
        logger.debug("Update password request received");
        return newUserManagementService.updatePassword(request.getName(), request.getNewPassword());
    }

    @PostMapping("/addgroup")
    public Group addGroup(@RequestBody Group request) {
        return newUserManagementService.addGroup(request);
    }

    @PostMapping("/addrole")
    public Role addRole(@RequestBody Role request) {
        return newUserManagementService.addRole(request);
    }

    @GetMapping("/users")
    public List<User> getUsers() {
        return newUserManagementService.getAllUsers();
    }

    @GetMapping("/groups")
    public List<Group> getGroups() {
        return newUserManagementService.getAllGroups();
    }

    @GetMapping("/hello")
    public String test() {
        return "<h1>Working</h1>";
    }

}
