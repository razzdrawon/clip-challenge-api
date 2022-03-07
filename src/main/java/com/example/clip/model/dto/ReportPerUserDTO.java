package com.example.clip.model.dto;

import java.math.BigDecimal;
import java.util.List;

import com.example.clip.model.Payment;

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
public class ReportPerUserDTO {
	
	private Long userId;
	private String firstName;
	private String lastName;
	private BigDecimal paymentsSum;
	private BigDecimal newPaymentsSum;
	private List<Payment> newPayments;

}
