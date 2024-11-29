package com.mung.square.payment.mapper;

import com.mung.square.dto.PaymentDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PaymentMapper {
    void insertPayment(PaymentDTO paymentDTO);
}