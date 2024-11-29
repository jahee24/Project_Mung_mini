package com.mung.square.payment.mapper;

import com.mung.square.dto.ReservationDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface OrderMapper {
    ReservationDTO getLatestReservationByUserId(@Param("userId") String userId);
}
