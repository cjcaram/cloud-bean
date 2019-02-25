package com.enano.cloudbean.services;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.enano.cloudbean.dtos.UserProfile;
import com.enano.cloudbean.dtos.CompanyDto;
import com.enano.cloudbean.dtos.UserDto;
import com.enano.cloudbean.entities.User;
import com.enano.cloudbean.repositories.ComercialEntityRepository;
import com.enano.cloudbean.repositories.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    @Autowired
    private PasswordEncoder passwordEncoder;
    
    @Autowired
    private ComercialEntityRepository companyRepo;

    public UserProfile getUserProfileByUsername(String username){
      return repo.getUserProfile(username);
    }
    
    public List<User> getAllUsers(){
      return repo.findAll();
    }
    
    public List<UserDto> getActiveUsers(){
      List<User> userList = repo.getUsersWhereUserIsActive();
      
      List<UserDto> userDtoList = userList.stream()
          .map(tmpUsr -> getUserDtoFromUserEntity(tmpUsr))
          .collect(Collectors.toList());
      return userDtoList;
    }

    private UserDto getUserDtoFromUserEntity(User tmpUsr) {
      UserDto userDto = new UserDto();
      userDto.setId(tmpUsr.getId().intValue());
      userDto.setRole(tmpUsr.getRole());
      userDto.setUsername(tmpUsr.getUserName());
      CompanyDto companyDto = new CompanyDto();
      if (tmpUsr.getCompany() != null) {
        companyDto.setId(tmpUsr.getCompany().getId());
        companyDto.setName(tmpUsr.getCompany().getName());
      } else {
        companyDto.setId(-1L);
        companyDto.setName("Usuario sin compañia asignada");
      }
      userDto.setCompany(companyDto);
      return userDto;
    }

    public User getUserByUsername(String username) {
      return repo.findByUserName(username).get();
    }

    public User setUserAsInactived(Integer id) {
      User oldUser = repo.getOne(id.longValue());
      oldUser.setActive(false);
      return repo.saveAndFlush(oldUser);
    }
    
    public User save(UserDto userRegistration){
      User newUser = getUserFromUserRegistration(userRegistration);
      newUser.setPassword(passwordEncoder.encode(userRegistration.getPassword()));
      return repo.saveAndFlush(newUser);
    }
    
    public User updateUserWithNoPswrd(UserDto userRegistration) {
      long id = userRegistration.getId().longValue();
      User userToUpdate = getUserFromUserRegistration(userRegistration);
      User existingUser = repo.getOne(id);
      userToUpdate.setId(id);
      userToUpdate.setPassword(existingUser.getPassword());
      return repo.saveAndFlush(userToUpdate);
    }

    public User updateUser(UserDto userRegistration) {
      User userToUpdate = getUserFromUserRegistration(userRegistration);
      userToUpdate.setId(userRegistration.getId().longValue());
      userToUpdate.setPassword(userRegistration.getPassword());
      return repo.saveAndFlush(userToUpdate);
      
    }
    
    private User getUserFromUserRegistration(UserDto userDto) {
      User newUser = new User();
      newUser.setActive(true);
      newUser.setModificationDate(new Date());
      newUser.setRole(userDto.getRole());
      newUser.setUserName(userDto.getUsername());
      newUser.setCompany(companyRepo.findById((userDto.getCompany().getId().longValue())).get());
      return newUser;
    }

}
