package com.example.clip.controller;

import java.math.RoundingMode;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.clip.model.Payment;
import com.example.clip.model.dto.PaymentDTO;
import com.example.clip.model.dto.ReportPerUserDTO;
import com.example.clip.request.PaymentRequest;
import com.example.clip.service.TransactionService;

@RestController
@RequestMapping("/api/clip")
public class TransactionController {

	@Autowired
	TransactionService transactionService;

	@PostMapping("/payments")
	public ResponseEntity<PaymentDTO> create(@RequestBody PaymentRequest paymentRequest) {
		Payment payment = new Payment(paymentRequest.getAmount().setScale(2, RoundingMode.HALF_EVEN),
				paymentRequest.getUserId(), paymentRequest.getCardInfo());
		return new ResponseEntity<>(transactionService.createPayment(payment), HttpStatus.CREATED);

	}

	@GetMapping("/payments")
	public ResponseEntity<List<PaymentDTO>> getAllPayments() {
		return new ResponseEntity<>(transactionService.getAllPayments(), HttpStatus.OK);
	}
	
	@GetMapping("/payments/report/{userId}")
	public ResponseEntity<ReportPerUserDTO> getAllPayments(@PathVariable Long userId) {
		return new ResponseEntity<>(transactionService.createReportPerUser(userId), HttpStatus.OK);
	}

}
