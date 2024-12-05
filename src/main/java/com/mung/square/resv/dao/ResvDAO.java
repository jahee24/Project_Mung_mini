package com.mung.square.resv.dao;

import com.mung.square.dto.ResvDTO;

public interface ResvDAO {

    boolean isTimeAvailable(ResvDTO resvDTO);  // 예약 시간 중복 체크
    int insertReservation(ResvDTO resvDTO);
}
