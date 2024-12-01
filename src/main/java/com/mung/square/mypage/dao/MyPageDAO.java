package com.mung.square.mypage.dao;

import com.mung.square.dto.DogDTO;
import com.mung.square.dto.ReservationForMypageDTO;
import com.mung.square.dto.UserDTO;

import java.util.List;

public interface MyPageDAO {
    UserDTO getUser(String id);
    List<DogDTO> getDogList(String id);
    List<ReservationForMypageDTO> getResv(String id);
    DogDTO getDogById(String id);
    void insertDog(DogDTO dog);
}
