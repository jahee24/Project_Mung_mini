package com.mung.square.payment.service;

import com.mung.square.dto.ReservationDTO;
import com.mung.square.payment.dao.OrderDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderDAO orderDAO;

    @Override
    public ReservationDTO getLatestReservationByUserId(String userId) {
        ReservationDTO reservationDTO = new ReservationDTO();

        return orderDAO.getLatestReservationByUserId(userId);
    }
}
