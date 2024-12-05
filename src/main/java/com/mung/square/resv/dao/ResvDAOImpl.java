package com.mung.square.resv.dao;

import com.mung.square.dto.ResvDTO;
import com.mung.square.resv.mapper.ResvMapper;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

    @Repository
    @RequiredArgsConstructor
    public class ResvDAOImpl implements ResvDAO {
        private final ResvMapper resvMapper;
        private final SqlSession sqlSession;

    
        @Override
        public boolean isTimeAvailable(ResvDTO resvDTO) {
            // 예약 시간이 겹치는지 확인하는 MyBatis 쿼리 호출
            Integer count = sqlSession.selectOne("ResvMapper.checkOverlap", resvDTO);
            return count == 0;  // 겹치는 예약이 없으면 true
        }

        public int insertReservation(ResvDTO resvDTO) {
            return resvMapper.insertReservation(resvDTO);
        }
    }
