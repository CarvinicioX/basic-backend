package com.sinch.backend.repository;

import com.sinch.backend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.Collection;

@RepositoryRestResource(collectionResourceRel = "users", path = "users")
public interface UserRepository extends JpaRepository<User, Long> {

    @RestResource(path = "/top")
    @Query(
        value = "SELECT * FROM USERS WHERE ID IN (SELECT TOP 5 USER_ID FROM SALES GROUP BY USER_ID ORDER BY SUM(TOTAL) DESC)",
        nativeQuery = true
    )
    Collection<User> findTopUsers();

    @RestResource(path = "/usersCount")
    @Query(
            value = "SELECT COUNT(*) FROM USERS",
            nativeQuery = true
    )
    Integer calculateUserCount();

}
