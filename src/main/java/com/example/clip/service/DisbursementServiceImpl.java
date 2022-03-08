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

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.clip.model.Disbursement;
import com.example.clip.model.Payment;
import com.example.clip.model.User;
import com.example.clip.model.dto.DisbursementDTO;
import com.example.clip.model.dto.UserDisbursementDTO;
import com.example.clip.repository.DisbursementRepository;
import com.example.clip.repository.PaymentRepository;
import com.example.clip.repository.UserRepository;

/**
 * @author Ricardo Padilla
 *
 */
@Service
public class DisbursementServiceImpl implements DisbursementService {

	private static final BigDecimal FEE = BigDecimal.valueOf(1 - 0.035);

	@Autowired
	private PaymentRepository paymentRepository;

	@Autowired
	private DisbursementRepository disbursementRepository;

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	ModelMapper mapper;

	@Override
	public List<UserDisbursementDTO> processDisbursements() {
		List<UserDisbursementDTO> usersDto = new ArrayList<>();
		List<Payment> payments = paymentRepository.findByIsDisbursed(false);
		Map<Long, List<Payment>> paymentsByUser = payments.stream().collect(Collectors.groupingBy(Payment::getUserId));
		for (Long userId : paymentsByUser.keySet()) {
			BigDecimal amountPayment = BigDecimal.ZERO;
			for (Payment payment : paymentsByUser.get(userId)) {
				amountPayment = amountPayment.add(payment.getAmount());
				payment.setIsDisbursed(true);
				paymentRepository.save(payment);
			}
			User user = userRepository.getById(userId);
			Disbursement disbursement = disbursementRepository.save(new Disbursement(amountPayment,
					amountPayment.multiply(FEE).setScale(2, RoundingMode.HALF_EVEN), userId));
			UserDisbursementDTO userDto = new UserDisbursementDTO(userId, user.getFirstName(), user.getLastName(),
					disbursement.getAmountPayment(), disbursement.getAmountDisbursement());
			usersDto.add(userDto);
		}
		return usersDto;
	}

	@Override
	public List<DisbursementDTO> getAllDisbursements() {
		return mapper.map(disbursementRepository.findAll(), new TypeToken<List<DisbursementDTO>>(){}.getType());
	}

}
