package com.enano.cloudbean.servicies;

//import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.enano.cloudbean.repositories.UserRepository;

/**
 *
 * @author developer
 */
@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository repo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return repo
                .findByUserName(username)
                .map(u -> new org.springframework.security.core.userdetails.User(
                u.getUserName(),
                u.getPassword(),
                u.isActive(),
                u.isActive(),
                u.isActive(),
                u.isActive(),
                AuthorityUtils.createAuthorityList("ROLE_ADMIN")
//                AuthorityUtils.createAuthorityList(
//                        u.getRoles()
//                                .stream()
//                                .map(r -> "ROLE_" + r.getName().toUpperCase())
//                                .collect(Collectors.toList())
//                                .toArray(new String[]{}))
                ))
                .orElseThrow(() -> new UsernameNotFoundException("No user with "
                        + "the name " + username + "was found in the database"));
    }

}