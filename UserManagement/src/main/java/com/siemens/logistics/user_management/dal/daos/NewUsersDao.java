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
    @Query(value="select u.id,u.name,u.description,u.department,r.name as role_name, g.name as group_name from users u\n" +
            "inner join roles r on u.role_id = r.role_id\n" +
            "inner join groups g on u.group_id= g.id", nativeQuery = true)
    List<User> fetchUsers();

    public static interface NameOnly {

        String getRoleName();

        String getGroupName();

    }

}
