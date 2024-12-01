package com.mung.square.payment.dao;

import com.mung.square.dto.PaymentDTO;

public interface PaymentDAO {
    void insertPayment(PaymentDTO paymentDTO);
}
