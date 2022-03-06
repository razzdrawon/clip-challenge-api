/**
 * 
 */
package com.example.clip.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.clip.model.User;

/**
 * @author Ricardo Padilla
 *
 */
public interface UserRepository extends JpaRepository<User, Long> {
	
	List<User> findByFirstName(String firstName);
	
	@Query("SELECT DISTINCT u FROM User u, Payment p WHERE u.userId = p.userId")
	List<User> findUserWithPayment();
	
}
