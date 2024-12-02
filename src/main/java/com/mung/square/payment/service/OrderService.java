package com.mung.square.payment.service;

import com.mung.square.dto.ReservationDTO;

public interface OrderService {
    ReservationDTO getLatestReservationByUserId (String userId);
}
