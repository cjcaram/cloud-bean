package com.enano.cloudbean.servicies;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.enano.cloudbean.dtos.UserProfile;
import com.enano.cloudbean.entities.User;
import com.enano.cloudbean.repositories.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public void save(User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        repo.save(user);
    }
    
    public UserProfile getUserProfileByUsername(String username){
      return repo.getUserProfile(username);
    }
    
    public List<User> getAllUsers(){
      return repo.findAll();
    }

    public User getUserByUsername(String username) {
      return repo.findByUserName(username).get();
    }

}
