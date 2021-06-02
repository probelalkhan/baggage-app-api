package com.siemens.logistics.user_management.dal;

import com.siemens.logistics.user_management.model.table_models.user.UserTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao extends JpaRepository<UserTable, Long> {
    List<UserTable> findByUserName(String username);
}
