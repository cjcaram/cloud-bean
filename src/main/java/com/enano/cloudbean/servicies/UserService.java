package com.enano.cloudbean.servicies;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.enano.cloudbean.dtos.UserProfile;
import com.enano.cloudbean.dtos.UserRegistration;
import com.enano.cloudbean.entities.User;
import com.enano.cloudbean.repositories.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public UserProfile getUserProfileByUsername(String username){
      return repo.getUserProfile(username);
    }
    
    public List<User> getAllUsers(){
      return repo.findAll();
    }
    
    public List<User> getActiveUsers(){
      return repo.getUsersWhereUserIsActive();
    }

    public User getUserByUsername(String username) {
      return repo.findByUserName(username).get();
    }

    public User setUserAsInactived(int id) {
      User oldUser = repo.findById(Long.valueOf(id)).get();
      oldUser.setActive(false);
      return repo.saveAndFlush(oldUser);
    }
    
    public User save(UserRegistration userRegistration){
      User newUser = getUserFromUserRegistration(userRegistration);
      newUser.setPassword(passwordEncoder.encode(userRegistration.getPassword()));
      return repo.save(getUserFromUserRegistration(userRegistration));
    }
    
    public User updateUserWithNoPswrd(UserRegistration userRegistration) {
      long id = userRegistration.getId().longValue();
      User userToUpdate = getUserFromUserRegistration(userRegistration);
      User existingUser = repo.getOne(id);
      userToUpdate.setId(id);
      userToUpdate.setPassword(existingUser.getPassword());
      return repo.saveAndFlush(userToUpdate);
    }

    public User updateUser(UserRegistration userRegistration) {
      User userToUpdate = getUserFromUserRegistration(userRegistration);
      userToUpdate.setId(userRegistration.getId().longValue());
      return repo.saveAndFlush(userToUpdate);
      
    }
    
    private User getUserFromUserRegistration(UserRegistration userRegistration) {
      User newUser = new User();
      newUser.setActive(true);
      newUser.setModificationDate(new Date());
      newUser.setRole(userRegistration.getRole());
      newUser.setUserName(userRegistration.getUsername());
      return newUser;
    }

}
