package com.coding.register.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.coding.register.models.User;

@Repository
public interface UserRepository extends CrudRepository<User,Long>{
//	Find my email
	Optional<User> findByEmail(String email);

}
