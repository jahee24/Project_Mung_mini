package com.mung.square.payment.service;

import com.mung.square.dto.CancelResponse;
import com.mung.square.dto.RefundDTO;
import com.mung.square.payment.dao.RefundDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RefundServiceImpl implements RefundService{
    private final RefundDAO refundDAO;

    @Override
    public RefundDTO getRefund(int orderNum) {
        return refundDAO.getRefund(orderNum);
    }
}
