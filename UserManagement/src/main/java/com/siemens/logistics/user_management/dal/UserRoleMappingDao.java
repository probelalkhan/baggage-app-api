package com.siemens.logistics.user_management.dal;

import com.siemens.logistics.user_management.model.table_models.user.UserRoleMappingTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRoleMappingDao extends JpaRepository<UserRoleMappingTable, Long> {
    List<UserRoleMappingTable> findByUserId(long id);
}
