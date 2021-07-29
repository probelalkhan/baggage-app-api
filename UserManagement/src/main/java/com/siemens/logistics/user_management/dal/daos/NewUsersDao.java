package com.siemens.logistics.user_management.dal.daos;

import com.siemens.logistics.user_management.model.v2.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NewUsersDao extends JpaRepository<User, Long> {
    List<User> findByName(String name);

    @Modifying(clearAutomatically = true)
    @Query(value = "UPDATE USERS SET password = :newPassword WHERE name = :name", nativeQuery = true)
    User updatePassword(@Param("name") String name, @Param("newPassword") String newPassword);
}
