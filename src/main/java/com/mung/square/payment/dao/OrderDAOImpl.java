package com.mung.square.payment.dao;

import com.mung.square.dto.ReservationDTO;
import com.mung.square.payment.mapper.OrderMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class OrderDAOImpl implements OrderDAO{
    private final OrderMapper orderMapper;


    @Override
    public ReservationDTO getLatestReservationByUserId(String userId) {
        return orderMapper.getLatestReservationByUserId(userId);
    }
}
