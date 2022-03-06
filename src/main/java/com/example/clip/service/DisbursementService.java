package com.example.clip.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.clip.model.Disbursement;

/**
 * @author Ricardo Padilla
 *
 */
@Service
public interface DisbursementService {
	
	public List<Disbursement> processDisbursements();
	
	public List<Disbursement> getAllDisbursements();

}
