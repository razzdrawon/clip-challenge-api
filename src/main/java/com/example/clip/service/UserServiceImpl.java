/**
 * 
 */
package com.example.clip.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.clip.model.dto.UserDTO;
import com.example.clip.repository.UserRepository;

/**
 * @author Ricardo Padilla
 *
 */
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	ModelMapper mapper;

	@Override
	public List<UserDTO> getAllUsers() {
		return mapper.map(userRepository.findAll(), new TypeToken<List<UserDTO>>(){}.getType());
	}

	@Override
	public List<UserDTO> getUsersWithPayments() {
		return mapper.map(userRepository.findUserWithPayment(), new TypeToken<List<UserDTO>>(){}.getType());
	}

	@Override
	public UserDTO getUserById(Long userId) {
		return mapper.map(userRepository.findById(userId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
				String.format("User ID: %d not found", userId))), UserDTO.class);
	}

	@Override
	public List<UserDTO> getUserByFirstName(String firstName) {
		return mapper.map(userRepository.findByFirstName(firstName), new TypeToken<List<UserDTO>>(){}.getType());
	}

}
