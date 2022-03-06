/**
 * 
 */
package com.example.clip.model.dto;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @author Ricardo Padilla
 *
 */
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class UserDisbursementDTO {
	private Long userId;
	private String firstName;
	private String lastName;
	private BigDecimal payment;
	private BigDecimal disbursement;
}
