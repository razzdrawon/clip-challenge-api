package com.example.clip.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.clip.model.Payment;

/**
 * @author Ricardo Padilla
 *
 */
@Service
public interface TransactionService {

	public List<Payment> getAllPayments();

	public Payment createPayment(Payment payment);

}
