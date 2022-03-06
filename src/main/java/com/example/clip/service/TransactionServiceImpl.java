/**
 * 
 */
package com.example.clip.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.clip.model.Payment;
import com.example.clip.repository.PaymentRepository;

/**
 * @author Ricardo Padilla
 *
 */
@Service
public class TransactionServiceImpl implements TransactionService {
	
	@Autowired
	private PaymentRepository paymentRepository;

	@Override
	public List<Payment> getAllPayments() {
		return paymentRepository.findAll();
	}

	@Override
	public Payment createPayment(Payment payment) {
		payment.setIsDisbursed(false);
		return paymentRepository.save(payment);
	}

}
