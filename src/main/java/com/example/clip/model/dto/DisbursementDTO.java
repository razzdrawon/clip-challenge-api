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
public class DisbursementDTO {
	
	private Long disbursementId;
	private BigDecimal amountPayment;
	private BigDecimal amountDisbursement;
	private Long userId;
	private Date createdDt;

}
