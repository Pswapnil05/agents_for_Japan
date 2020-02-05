package com.innovecture.agentsforJapan.controller;

import com.innovecture.agentsforJapan.model.Agency;
import com.innovecture.agentsforJapan.model.User;
import com.innovecture.agentsforJapan.service.AgencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/agency")
public class AgencyController {

  @Autowired
  private AgencyService agencyService;

  @GetMapping
  public ResponseEntity<List<Agency>> getAllAgencies () {
    return new ResponseEntity<List<Agency>>(agencyService.getAllAgencies(), HttpStatus.OK);
  }

  @GetMapping("{agency_code}")
  public ResponseEntity<Agency> getAgencyById (@PathVariable Integer agency_code) {
    return new ResponseEntity<Agency>(agencyService.getAgencyById(agency_code), HttpStatus.OK);
  }

  @PostMapping
  public void addAgency(@RequestBody Agency agency) {
    agencyService.addAgency(agency);
  }
}
