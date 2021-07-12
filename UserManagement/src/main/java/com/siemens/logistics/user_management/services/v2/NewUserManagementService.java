package com.siemens.logistics.user_management.services.v2;

import com.siemens.logistics.common.exception.GenericException;
import com.siemens.logistics.user_management.dal.RoleDao;
import com.siemens.logistics.user_management.dal.UserRoleMappingDao;
import com.siemens.logistics.user_management.dal.daos.GroupsDao;
import com.siemens.logistics.user_management.dal.daos.NewRoleDao;
import com.siemens.logistics.user_management.dal.daos.NewUsersDao;
import com.siemens.logistics.user_management.dal.daos.UserGroupDao;
import com.siemens.logistics.user_management.model.api_models.user.UserModel;
import com.siemens.logistics.user_management.model.table_models.user.RoleTable;
import com.siemens.logistics.user_management.model.table_models.user.UserRoleMappingTable;
import com.siemens.logistics.user_management.model.table_models.user.UserTable;
import com.siemens.logistics.user_management.model.v2.Group;
import com.siemens.logistics.user_management.model.v2.Role;
import com.siemens.logistics.user_management.model.v2.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class NewUserManagementService {

    @Autowired
    RoleDao roleDao;

    @Autowired
    UserRoleMappingDao userRoleMappingDao;

    @Autowired
    GroupsDao groupsDao;
    @Autowired
    NewUsersDao newUsersDao;
    @Autowired
    UserGroupDao userGroupDao;
    @Autowired
    NewRoleDao newRoleDao;

    private static Logger logger = LogManager.getLogger(NewUserManagementService.class);

    public User addUser(User request) {
        return newUsersDao.save(request);
    }

    public Group addGroup(Group request) {
        return groupsDao.save(request);
    }

    public Role addRole(Role request) {
        return newRoleDao.save(request);
    }

    public List<User> getAllUsers() {
        return newUsersDao.findAll();
    }

    public User getUser(String username) {
        List<User> userList = newUsersDao.findByName(username);

        if(userList.isEmpty()){
            logger.debug("No user found for given username");
            throw new GenericException(HttpStatus.BAD_REQUEST, 400, 4001, null);
        }

        User user = userList.get(0);

        //Now getting all the user roles
        List<UserRoleMappingTable> mappingList = userRoleMappingDao.findByUserId(user.getId());
        return user;
    }
}
