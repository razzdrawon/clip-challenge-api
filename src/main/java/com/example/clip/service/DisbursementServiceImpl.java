/**
 * 
 */
package com.example.clip.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.clip.model.Disbursement;
import com.example.clip.model.Payment;
import com.example.clip.repository.DisbursementRepository;
import com.example.clip.repository.PaymentRepository;

/**
 * @author Ricardo Padilla
 *
 */
@Service
public class DisbursementServiceImpl implements DisbursementService {
	
	private static final BigDecimal FEE = new BigDecimal(1 - 0.035);
	
	@Autowired
	private PaymentRepository paymentRepository;
	
	@Autowired
	private DisbursementRepository disbursementRepository;

	@Override
	public List<Disbursement> processDisbursements() {
		List<Payment> payments = paymentRepository.findByIsDisbursed(false);
		Map<Long, List<Payment>> paymentsByUser = payments.stream().collect(Collectors.groupingBy(Payment::getUserId));
		List<Disbursement> disbursements = new ArrayList<>();
		for (Long userId : paymentsByUser.keySet()) {
			BigDecimal amount = BigDecimal.ZERO;
			for (Payment payment : paymentsByUser.get(userId)) {
				amount = amount.add(payment.getAmount().multiply(FEE).setScale(2, RoundingMode.HALF_EVEN));
				payment.setIsDisbursed(true);
				paymentRepository.save(payment);
			}
			disbursements.add(disbursementRepository.save(new Disbursement(amount, userId)));
		}
		return disbursements;
	}

	@Override
	public List<Disbursement> getAllDisbursements() {
		return disbursementRepository.findAll();
	}

}
