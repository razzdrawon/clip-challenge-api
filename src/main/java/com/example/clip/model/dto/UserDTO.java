package com.example.clip.model.dto;

import java.io.Serializable;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Ricardo Padilla
 *
 */
@Getter
@Setter
public class UserDTO implements Serializable {
	
	private static final long serialVersionUID = -7954724119441960336L;
	private Long userId;
	private String firstName;
	private String lastName;
	private Date createdDt;

}
