package com.siemens.logistics.user_management.dal.daos;

import com.siemens.logistics.user_management.model.v2.Group;
import com.siemens.logistics.user_management.model.v2.UserGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserGroupDao extends JpaRepository<UserGroup, Long> {
}
