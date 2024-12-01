package com.mung.square.payment.dao;

import com.mung.square.dto.PaymentDTO;
import com.mung.square.payment.mapper.PaymentMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class PaymentImpl implements PaymentDAO{
    private final PaymentMapper paymentMapper;

    @Override
    public void insertPayment(PaymentDTO paymentDTO) {
        paymentMapper.insertPayment(paymentDTO);
    }
}
