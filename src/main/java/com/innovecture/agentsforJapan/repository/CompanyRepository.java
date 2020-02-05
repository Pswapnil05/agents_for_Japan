package com.innovecture.agentsforJapan.repository;

import com.innovecture.agentsforJapan.model.Company;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CompanyRepository extends CrudRepository<Company, Integer> {


}
