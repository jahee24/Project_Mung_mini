package com.mung.square.mypage.dao;

import com.mung.square.dto.DogDTO;
import com.mung.square.dto.UserDTO;
import com.mung.square.mypage.mapper.MyPageMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class MyPageDAOImple implements MyPageDAO {
    private final MyPageMapper mapper;

    @Override
    public UserDTO getUser(String id) {
        return mapper.getuser(id);
    }

    @Override
    public List<DogDTO> getDog(String id) {
        return mapper.getdog(id);
    }
}
