package com.example.clip.service;

import java.math.BigDecimal;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.clip.model.Payment;
import com.example.clip.model.User;
import com.example.clip.model.dto.PaymentDTO;
import com.example.clip.model.dto.ReportPerUserDTO;
import com.example.clip.repository.PaymentRepository;
import com.example.clip.repository.UserRepository;

/**
 * @author Ricardo Padilla
 *
 */
@Service
public class TransactionServiceImpl implements TransactionService {

	@Autowired
	private PaymentRepository paymentRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	ModelMapper mapper;

	@Override
	public List<PaymentDTO> getAllPayments() {
		return mapper.map(paymentRepository.findAll(), new TypeToken<List<PaymentDTO>>(){}.getType());
	}

	@Override
	public PaymentDTO createPayment(Payment payment) {
		payment.setIsDisbursed(false);
		userRepository.findById(payment.getUserId()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
				String.format("User ID: %d not found", payment.getUserId())));
		return mapper.map(paymentRepository.save(payment), PaymentDTO.class);
	}

	@Override
	public ReportPerUserDTO createReportPerUser(Long userId) {
		User user = userRepository.findById(userId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
				String.format("User ID: %d not found", userId)));
		List<Payment> payments = paymentRepository.findByUserId(userId);
		BigDecimal total_sum = payments.stream().filter(pay -> pay.getAmount() != null)
				.map(Payment::getAmount).reduce(BigDecimal.ZERO, BigDecimal::add);
		BigDecimal new_sum = payments.stream().filter(pay -> (pay.getAmount() != null && pay.getIsDisbursed() == false))
				.map(Payment::getAmount).reduce(BigDecimal.ZERO, BigDecimal::add);
		
		return new ReportPerUserDTO(userId, user.getFirstName(), user.getLastName(), total_sum, new_sum, payments);
	}

}
