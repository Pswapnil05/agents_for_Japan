package com.innovecture.agentsforJapan.service;


import com.innovecture.agentsforJapan.model.Address;
import com.innovecture.agentsforJapan.model.Agency;
import com.innovecture.agentsforJapan.model.Company;
import com.innovecture.agentsforJapan.model.User;
import com.innovecture.agentsforJapan.repository.AgencyRepository;
import com.innovecture.agentsforJapan.repository.CompanyRepository;
import com.innovecture.agentsforJapan.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AgencyService {

  @Autowired
  private AgencyRepository agencyRepository;
  @Autowired
  private CompanyRepository companyRepository;
  @Autowired
  private UserRepository userRepository;

  public List<Agency> getAllAgencies () {
//    addData();
    return (List<Agency>) agencyRepository.findAll();
  }

  public Agency getAgencyById(Integer agency_code) {
    return agencyRepository.findById(agency_code).orElse(null);
  }

  public void addAgency(Agency agency) {
    agencyRepository.save(agency);
  }

  public void addData() {

    Agency agency1 = new Agency("Flightpath", "1111111111",
    "flightpath@domain.com", new Address("West Street",
    "NY","NY","10010","USA"));

    User user11 = new User("Flight","1010101010","user11@domain.com",
    new Address("West","NY","NY","10010","USA"));

    Company company11 = new Company("Path","1100110011","company11@domain.com",
    new Address("Street","NY","NY","10010","USA"));

    /**
     *create ArrayList for user & company
     */
    List<User> userList1 = new ArrayList<>();
    List<Company> companyList1 = new ArrayList<>();

    /**
     * add user & company in the respective list
     */
    userList1.add(user11);
    companyList1.add(company11);

    /**
     * set userlist & companylist to respective agency
     */
    agency1.setUsers(userList1);
    agency1.setCompanies(companyList1);

    /**
     * save objects to the respective repository
     */
    agencyRepository.save(agency1);
    userRepository.save(user11);
    companyRepository.save(company11);

  }


}
