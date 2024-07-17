package com.example.farmfarm_refact.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum PaymentStatus {
    BEFORE_PAYMENT(1),
    PAYMENT_COMPLETED(2);
    private final Integer statusNum;
}
