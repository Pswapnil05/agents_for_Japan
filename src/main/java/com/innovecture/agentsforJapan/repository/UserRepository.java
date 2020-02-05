package com.innovecture.agentsforJapan.repository;

import com.innovecture.agentsforJapan.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends CrudRepository<User, Integer> {



}
