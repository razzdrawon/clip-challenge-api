package com.example.clip.model.dto;

import java.math.BigDecimal;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Ricardo Padilla
 *
 */
@Getter
@Setter
public class PaymentDTO {
	
	private Long paymentId;
	private BigDecimal amount;
	private Long userId;
	private Boolean isDisbursed;
	private String cardInfo;
	private Date createdDt;

}
