package com.mung.square.resv.service;

import com.mung.square.dto.ResvDTO;
import com.mung.square.resv.dao.ResvDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ResvServiceImpl implements ResvService {

    private final ResvDAO resvDAO;

    @Override
    public boolean isReservationAvailable(ResvDTO resvDTO) {
        // 예약 시간이 겹치는지 확인
        return resvDAO.isTimeAvailable(resvDTO);
    }

    public void createReservation(ResvDTO resvDTO) {
        resvDAO.insertReservation(resvDTO);
    }

}
