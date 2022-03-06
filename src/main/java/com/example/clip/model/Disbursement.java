	package com.example.clip.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "disbursement")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@NoArgsConstructor
public class Disbursement {

    @Id
    @Column(name = "disbursement_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long disbursementId;
    
    @NonNull
    @Column(name = "amount_payment")
    private BigDecimal amountPayment;
    
    @NonNull
    @Column(name = "amount_disbursement")
    private BigDecimal amountDisbursement;
    
    @NonNull
    @Column(name = "user_id")
    private Long userId;
    
    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_dt")
	private Date createdDt;
    
}
