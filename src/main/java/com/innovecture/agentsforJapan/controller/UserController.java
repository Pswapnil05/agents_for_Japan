package com.innovecture.agentsforJapan.controller;


import com.innovecture.agentsforJapan.model.User;
import com.innovecture.agentsforJapan.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/agency/user")
public class UserController {


  @Autowired
  private UserService userService;

  @PostMapping("{agency_code}")
  public void addUser(@RequestBody User user, @PathVariable Integer agency_code) {
      userService.addUser(user, agency_code);
  }

  @GetMapping("{agency_code}")
  public ResponseEntity<List<User>> getUsersByAgencyId (@PathVariable Integer agency_code) {
    return new ResponseEntity<List<User>>(userService.getUsersByAgencyId(agency_code),
        HttpStatus.OK);
  }

}
