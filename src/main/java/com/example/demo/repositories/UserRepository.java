package com.example.demo.repositories;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.entityes.User;
import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Integer> {
	Optional<User> findByEmail(String email);

}
