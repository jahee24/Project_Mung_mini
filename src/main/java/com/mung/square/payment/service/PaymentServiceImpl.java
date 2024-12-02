package com.mung.square.payment.service;

import com.mung.square.dto.PaymentDTO;
import com.mung.square.payment.dao.PaymentDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService{
    private final PaymentDAO paymentDAO;

    @Override
    public void insertPayment(PaymentDTO paymentDTO) {
        paymentDAO.insertPayment(paymentDTO);
    }
}
