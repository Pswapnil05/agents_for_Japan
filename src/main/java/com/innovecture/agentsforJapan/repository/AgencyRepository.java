package com.innovecture.agentsforJapan.repository;

import com.innovecture.agentsforJapan.model.Agency;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgencyRepository extends CrudRepository<Agency, Integer> {


}
