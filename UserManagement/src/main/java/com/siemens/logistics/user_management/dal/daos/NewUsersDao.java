package com.siemens.logistics.user_management.dal.daos;

import com.siemens.logistics.user_management.model.v2.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface NewUsersDao extends JpaRepository<User, Long> {
    List<User> findByName(String name);

    @Modifying(clearAutomatically = true)
    @Query(value = "UPDATE USERS SET password = :newPassword WHERE name = :name", nativeQuery = true)
    int updatePassword(@Param("name") String name, @Param("newPassword") String newPassword);

    @Modifying(clearAutomatically = true)
    @Query(value = "UPDATE USERS SET first_failed_login = :failedLoginTime WHERE name = :name AND first_failed_login IS NULL", nativeQuery = true)
    int updateLoginFailed(@Param("name") String name, @Param("failedLoginTime") String failedLoginTime);


    @Modifying(clearAutomatically = true)
    @Query(value = "UPDATE USERS SET failed_logins = failed_logins + 1 WHERE name = :name", nativeQuery = true)
    int updateLoginFailedCount(@Param("name") String name);
}
