package com.example.clip.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.clip.model.User;

/**
 * @author Ricardo Padilla
 *
 */
@Service
public interface UserService {

	public List<User> getAllUsers();

	public List<User> getUsersWithPayments();

	public Optional<User> getUserById(Long userId);

	public List<User> getUserByFirstName(String firstName);

}
