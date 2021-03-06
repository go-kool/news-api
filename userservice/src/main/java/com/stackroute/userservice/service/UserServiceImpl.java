package com.stackroute.userservice.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stackroute.userservice.domain.User;
import com.stackroute.userservice.exception.UserAlreadyExistsException;
import com.stackroute.userservice.exception.UserNotFoundException;
import com.stackroute.userservice.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	public UserServiceImpl(UserRepository userRepo) {
		super();
		this.userRepository = userRepo;
	}

	@Override
	public boolean saveUser(User user) throws UserAlreadyExistsException {
		Optional<User> existingUser = userRepository.findByEmail(user.getEmail());
		if (existingUser.isPresent()) {
			throw new UserAlreadyExistsException();
		}
		userRepository.save(user);
		return true;
	}

	@Override
	public User findByEmailAndPassword(String email, String password) throws UserNotFoundException {
		User user = userRepository.findByEmailAndPassword(email, password);
		if (null == user) {
			throw new UserNotFoundException();
		}
		return user;
	}

}
