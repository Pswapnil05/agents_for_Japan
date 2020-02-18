package com.innovecture.agentsforJapan.controller;

import com.innovecture.agentsforJapan.model.Company;
import com.innovecture.agentsforJapan.model.User;
import com.innovecture.agentsforJapan.service.AgencyService;
import com.innovecture.agentsforJapan.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/agentsforjapan/agency/company")
public class CompanyController {

  @Autowired
  private CompanyService companyService;


  @PostMapping("{agency_code}")
  public void addCompany(@RequestBody Company company, @PathVariable Integer agency_code) {
    companyService.addCompany(company, agency_code);
  }

  @GetMapping("{agency_code}")
  public ResponseEntity<List<Company>> getCompaniesByAgencyId (@PathVariable Integer agency_code) {
    return new ResponseEntity<List<Company>>(companyService.getCompaniesByAgencyId(agency_code),
        HttpStatus.OK);
  }
}
