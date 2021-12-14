package com.flynn.authentication.repositories;

import org.springframework.stereotype.Repository;
import com.flynn.authentication.models.User;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
	Optional<User> findByEmail(String email);
}
