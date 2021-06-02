package com.siemens.logistics.user_management.services;

import com.siemens.logistics.common.exception.GenericException;
import com.siemens.logistics.user_management.dal.RoleDao;
import com.siemens.logistics.user_management.dal.UserDao;
import com.siemens.logistics.user_management.dal.UserRoleMappingDao;
import com.siemens.logistics.user_management.model.api_models.user.AddUserRequest;
import com.siemens.logistics.user_management.model.api_models.user.UserModel;
import com.siemens.logistics.user_management.model.table_models.user.RoleTable;
import com.siemens.logistics.user_management.model.table_models.user.UserRoleMappingTable;
import com.siemens.logistics.user_management.model.table_models.user.UserTable;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserDao userDao;

    @Autowired
    RoleDao roleDao;

    @Autowired
    UserRoleMappingDao userRoleMappingDao;

    private static Logger logger = LogManager.getLogger(UserService.class);


    private UserTable convertUserRequestToUser(AddUserRequest userRequest) {
        UserTable userTable = new UserTable();
        userTable.setActive(userRequest.getActive());
        userTable.setEmail(userRequest.getEmailId());
        userTable.setFirstName(userRequest.getFirstName());
        userTable.setLastName(userRequest.getLastName());
        userTable.setMobile(userRequest.getMobile());
        userTable.setUserName(userRequest.getUserName());
        userTable.setPassword(userRequest.getUserPassword());
        userTable.setLastUpdated(new Date());
        userTable.setCreatedOn(new Date());
        return userTable;
    }

    public List<UserTable> getAllUsers() {
        return userDao.findAll();
    }

    public UserModel getUser(String username) {
        List<UserTable> userList = userDao.findByUserName(username);

        if(userList.isEmpty()){
            logger.debug("No user found for given username");
            throw new GenericException(HttpStatus.BAD_REQUEST, 400, 4001, null);
        }

        UserTable user = userList.get(0);

        //Now getting all the user roles
        List<UserRoleMappingTable> mappingList = userRoleMappingDao.findByUserId(user.getId());

        if(mappingList.isEmpty()){
            logger.debug("No user role mapping found");
            throw new GenericException(HttpStatus.BAD_REQUEST, 400, 4002, null);
        }

        List<RoleTable> roles = new ArrayList<>();
        //Now getting all the roles

        mappingList.forEach(it -> {
            Optional<RoleTable> role = roleDao.findById(it.getRoleId());
            role.ifPresent(roles::add);
        });

        if(roles.isEmpty()){
            logger.debug("User role mapping invalid");
            throw new GenericException(HttpStatus.BAD_REQUEST, 400, 4002, null);
        }

        UserModel userModel = convertUserTableToUserModel(user);
        userModel.setRoles(roles);

        return userModel;
    }

    private UserModel convertUserTableToUserModel(UserTable userTable){
        UserModel userModel = new UserModel();

        userModel.setId(userTable.getId());
        userModel.setUserName(userTable.getUserName());
        userModel.setEmail(userTable.getEmail());
        userModel.setFirstName(userTable.getFirstName());
        userModel.setLastName(userTable.getLastName());
        userModel.setUserCode(userTable.getUserCode());
        userModel.setMobile(userTable.getMobile());
        userModel.setActive(userTable.getActive());
        userModel.setPassword(userTable.getPassword());

        return userModel;
    }

    public UserTable addUser(AddUserRequest request){
        UserTable table = convertUserRequestToUser(request);
        return userDao.save(table);
    }
}
