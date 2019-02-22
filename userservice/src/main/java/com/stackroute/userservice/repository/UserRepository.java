package com.stackroute.userservice.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.stackroute.userservice.domain.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	Optional<User> findByEmail(String email);

	User findByEmailAndPassword(String email, String password);

	@Query("Select user from User user where user.email = (?1) and user.password = (?2)")
	User validate(String email, String password);

}
