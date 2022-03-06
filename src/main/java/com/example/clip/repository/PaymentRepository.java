package com.example.clip.repository;

import com.example.clip.model.Payment;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.stereotype.Repository;

@EnableJpaAuditing
@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {
	List<Payment> findByUserId(Long userId);
	List<Payment> findByIsDisbursed(Boolean isDisbursed);
}
