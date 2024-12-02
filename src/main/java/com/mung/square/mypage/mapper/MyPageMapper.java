package com.mung.square.mypage.mapper;

import com.mung.square.dto.DogDTO;
import com.mung.square.dto.ReservationForMypageDTO;
import com.mung.square.dto.UserDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MyPageMapper {
    UserDTO getuser(String id);
    List<DogDTO> getdoglist(String id);
    List<ReservationForMypageDTO> getresv(String id);
    DogDTO getdogbyid(String id);
    void insertdog(DogDTO dog);
}

