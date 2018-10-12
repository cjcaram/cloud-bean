package com.enano.cloudbean.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.enano.cloudbean.dtos.UserProfile;
import com.enano.cloudbean.entities.User;

/**
 * User repository for CRUD operations.
 */
public interface UserRepository extends JpaRepository<User,Long> {
  @Query("SELECT NEW com.enano.cloudbean.dtos.UserProfile(u.userName, u.role) FROM User u WHERE u.userName = ?1 and u.active = true")
  UserProfile getUserProfile(String userName);
  
  Optional<User> findByUserName(String username);
  
  @Query("FROM User u WHERE u.active = true")
  List<User> getUsersWhereUserIsActive();
  
  @Query(value = "SELECT u.USER_NAME FROM users u WHERE u.COMPANY_ID = ?1 AND u.ACTIVE = true",
      nativeQuery = true)
  List<String> getUserProfilesByCompanyId(Integer company);
  
}
