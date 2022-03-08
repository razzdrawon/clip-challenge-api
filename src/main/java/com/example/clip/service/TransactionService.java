package com.example.clip.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.clip.model.Payment;
import com.example.clip.model.dto.PaymentDTO;
import com.example.clip.model.dto.ReportPerUserDTO;

/**
 * @author Ricardo Padilla
 *
 */
@Service
public interface TransactionService {

	public List<PaymentDTO> getAllPayments();

	public PaymentDTO createPayment(Payment payment);
	
	public ReportPerUserDTO createReportPerUser(Long userId);

}
