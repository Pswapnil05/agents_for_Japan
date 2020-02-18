package com.innovecture.agentsforJapan.repository;

import com.innovecture.agentsforJapan.model.DAORegisteredUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DAORegisteredUserRepository extends CrudRepository<DAORegisteredUser, Integer> {

   DAORegisteredUser findByUsername(String username);

}
