package com.mung.square.payment.dao;

import com.mung.square.dto.RefundDTO;
import com.mung.square.payment.mapper.RefundMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
@RequiredArgsConstructor
public class RefundDAOImpl implements RefundDAO{
    private final RefundMapper refundMapper;

    @Override
    public RefundDTO getRefund(int orderNum) {
        return refundMapper.selectRefundDetails(orderNum);
    }
}
