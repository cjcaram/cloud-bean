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
  // @Query("SELECT NEW com.enano.cloudbean.dtos.UserProfile(u.userName, r.name) FROM User u JOIN Role r on u.rolId = r.id WHERE u.userName = ?1")
  @Query("SELECT NEW com.enano.cloudbean.dtos.UserProfile(u.userName, u.role) FROM User u WHERE u.userName = ?1")
  UserProfile getUserProfile(String userName);
  
  Optional<User> findByUserName(String username);
  
  @Query("FROM User u WHERE u.active = true")
  List<User> getUsersWhereUserIsActive();
}
