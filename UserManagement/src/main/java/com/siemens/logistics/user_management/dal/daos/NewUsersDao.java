package com.siemens.logistics.user_management.dal.daos;

import com.siemens.logistics.user_management.model.table_models.user.UserTable;
import com.siemens.logistics.user_management.model.v2.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NewUsersDao extends JpaRepository<User, Long> {

    List<User> findByName(String name);
}
