/**
 * 
 */
package com.example.clip.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.clip.model.User;
import com.example.clip.repository.UserRepository;

/**
 * @author Ricardo Padilla
 *
 */
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	@Override
	public List<User> getUsersWithPayments() {
		return userRepository.findUserWithPayment();
	}

	@Override
	public User getUserById(Long userId) {
		return userRepository.findById(userId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
				String.format("User ID: %d not found", userId)));
	}

	@Override
	public List<User> getUserByFirstName(String firstName) {
		return userRepository.findByFirstName(firstName);
	}

}
