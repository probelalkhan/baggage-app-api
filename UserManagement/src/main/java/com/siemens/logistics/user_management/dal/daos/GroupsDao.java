package com.siemens.logistics.user_management.dal.daos;

import com.siemens.logistics.user_management.model.v2.Group;
import com.siemens.logistics.user_management.model.v2.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupsDao extends JpaRepository<Group, Long> {
}
