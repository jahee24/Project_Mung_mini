package com.mung.square.payment.mapper;

import com.mung.square.dto.RefundDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

@Mapper
public interface RefundMapper {
    RefundDTO selectRefundDetails(int orderNum);
}
