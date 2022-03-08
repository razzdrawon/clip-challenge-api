package com.example.clip.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.clip.model.dto.UserDTO;

/**
 * @author Ricardo Padilla
 *
 */
@Service
public interface UserService {

	public List<UserDTO> getAllUsers();

	public List<UserDTO> getUsersWithPayments();

	public UserDTO getUserById(Long userId);

	public List<UserDTO> getUserByFirstName(String firstName);

}
