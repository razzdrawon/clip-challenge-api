/**
 * 
 */
package com.example.clip.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.clip.model.User;
import com.example.clip.service.UserService;

/**
 * @author Ricardo Padilla
 *
 */
@RestController
@RequestMapping("/api/clip")
public class UserController {
	
	@Autowired
    private UserService userService;
	
	@GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers(){
		System.out.println(userService.getAllUsers());
    	return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }
	
	@GetMapping("/usersWithPayments")
    public ResponseEntity<List<User>> getUsersWithPayments(){
    	return new ResponseEntity<>(userService.getUsersWithPayments(), HttpStatus.OK);
    }
	
	@GetMapping("/users/{userId}")
    public ResponseEntity<Optional<User>> getUserById(@PathVariable Long userId){
    	return new ResponseEntity<>(userService.getUserById(userId), HttpStatus.OK);
    }
	
	@RequestMapping(value = "/users",
			params = "firstName",
		    method = RequestMethod.GET)
    public ResponseEntity<List<User>> getUserByFirstName(@RequestParam String firstName){
    	return new ResponseEntity<>(userService.getUserByFirstName(firstName), HttpStatus.OK);
    }
}
