package com.innovecture.agentsforJapan.service;


import com.innovecture.agentsforJapan.model.Company;
import com.innovecture.agentsforJapan.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyService {

  @Autowired
  private CompanyRepository companyRepository;

  @Autowired
  private AgencyService agencyService;

  public void addCompany(Company company, Integer agency_code) {
    agencyService.getAgencyById(agency_code).getCompanies().add(company);
    companyRepository.save(company);
  }

  public List<Company> getCompaniesByAgencyId(Integer agency_code) {
    return agencyService.getAgencyById(agency_code).getCompanies();
  }
}
