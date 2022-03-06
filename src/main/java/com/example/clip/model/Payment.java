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
@Table(name = "payment")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@NoArgsConstructor
public class Payment {

    @Id
    @Column(name = "payment_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long paymentId;
    
    @NonNull
    @Column(name = "amount")
    private BigDecimal amount;
    
    @NonNull
    @Column(name = "user_id")
    private Long userId;
    
    @Column(name = "is_disbursed")
    private Boolean isDisbursed;
    
    @NonNull
    @Column(name = "card_info")
    private String cardInfo;
    
    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_dt")
	private Date createdDt;
    
}
