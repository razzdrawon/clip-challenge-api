package com.example.clip.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;

@Getter
@Setter
@ToString
public class PaymentRequest {
    BigDecimal amount;
    Long userId;
    String cardInfo;
}
