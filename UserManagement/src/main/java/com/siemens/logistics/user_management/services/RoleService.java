package com.siemens.logistics.user_management.services;

import com.siemens.logistics.user_management.dal.RoleDao;
import com.siemens.logistics.user_management.model.table_models.user.RoleTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {

    @Autowired
    RoleDao roleDao;

    public List<RoleTable> getAllRoles() {
        return roleDao.findAll();
    }
}
