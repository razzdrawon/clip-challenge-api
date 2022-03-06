package com.example.clip.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.clip.model.Disbursement;
import com.example.clip.model.dto.UserDisbursementDTO;

/**
 * @author Ricardo Padilla
 *
 */
@Service
public interface DisbursementService {

	public List<UserDisbursementDTO> processDisbursements();

	public List<Disbursement> getAllDisbursements();

}
