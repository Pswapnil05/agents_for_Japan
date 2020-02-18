package com.innovecture.agentsforJapan.service;


import com.innovecture.agentsforJapan.model.DAORegisteredUser;
import com.innovecture.agentsforJapan.model.RegisteredUserDTO;
import com.innovecture.agentsforJapan.repository.DAORegisteredUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class JwtUserDetailsService implements UserDetailsService {

  @Autowired
  private DAORegisteredUserRepository daoRegisteredUserRepository;
  @Autowired
  private PasswordEncoder bcryptEncoder;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

    DAORegisteredUser user =  daoRegisteredUserRepository.findByUsername(username);
    if (user == null) {
      throw new UsernameNotFoundException("User not found with username: " + username);
    } else {
      return new org.springframework.security.core.userdetails.User(user.getUsername(),
          user.getPassword(), new ArrayList<>());
    }
  }

  public DAORegisteredUser saveUser(RegisteredUserDTO userDTO) {
    DAORegisteredUser daoUser = new DAORegisteredUser();
    daoUser.setUsername(userDTO.getUsername());
    daoUser.setPassword(bcryptEncoder.encode(userDTO.getPassword()));
    return daoRegisteredUserRepository.save(daoUser);
  }
}