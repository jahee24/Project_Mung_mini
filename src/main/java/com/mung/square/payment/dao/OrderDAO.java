package com.mung.square.payment.dao;

import com.mung.square.dto.ReservationDTO;

public interface OrderDAO {
    ReservationDTO getLatestReservationByUserId(String userId);
}
