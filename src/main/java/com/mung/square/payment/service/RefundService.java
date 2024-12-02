package com.mung.square.payment.service;

import com.mung.square.dto.CancelResponse;
import com.mung.square.dto.RefundDTO;

import java.util.Map;

public interface RefundService {
    RefundDTO getRefund(int orderNum);
}
