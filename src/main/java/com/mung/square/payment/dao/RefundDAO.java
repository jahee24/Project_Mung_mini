package com.mung.square.payment.dao;

import com.mung.square.dto.RefundDTO;

public interface RefundDAO {
    RefundDTO getRefund(int orderNum);
}
