package com.innovecture.agentsforJapan.service;


import com.innovecture.agentsforJapan.model.User;
import com.innovecture.agentsforJapan.repository.AgencyRepository;
import com.innovecture.agentsforJapan.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {


  @Autowired
  private UserRepository userRepository;
  @Autowired
  private AgencyService agencyService;

  public void addUser(User user, Integer agency_code) {
    agencyService.getAgencyById(agency_code).getUsers().add(user);
    userRepository.save(user);
  }

  public List<User> getUsersByAgencyId(Integer agency_code) {
    return agencyService.getAgencyById(agency_code).getUsers();
  }
}
