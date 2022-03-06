package com.example.clip.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.clip.model.Payment;
import com.example.clip.service.TransactionService;

@RestController
@RequestMapping("/api/clip")
public class TransactionController {

    @Autowired
    TransactionService transactionService;

    @PostMapping("/createPayload")
    public ResponseEntity<Payment> create(@RequestBody Payment payment) {
        return new ResponseEntity<>(transactionService.createPayment(payment), HttpStatus.CREATED);
        
    }
    
    @GetMapping("/payments")
    public ResponseEntity<List<Payment>> getAllPayments() {
		return new ResponseEntity<>(transactionService.getAllPayments(), HttpStatus.OK);
	}

}
