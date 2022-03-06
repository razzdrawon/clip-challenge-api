package com.example.clip.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.clip.model.Disbursement;
import com.example.clip.model.dto.UserDisbursementDTO;
import com.example.clip.service.DisbursementService;

@RestController
@RequestMapping("/api/clip")
public class DisbursementController {

    @Autowired
    DisbursementService disbursementService;


    @PostMapping("/disbursements")
	public ResponseEntity<List<UserDisbursementDTO>> processDisbursements() {
		return new ResponseEntity<>(disbursementService.processDisbursements(), HttpStatus.CREATED);
	}
    
    @GetMapping("/disbursements")
	public ResponseEntity<List<Disbursement>> getAllDisburse() {
		return new ResponseEntity<>(disbursementService.getAllDisbursements(), HttpStatus.OK);
	}

}
