package com.mung.square.mypage.dao;

import com.mung.square.dto.DogDTO;
import com.mung.square.dto.UserDTO;

import java.util.List;

public interface MyPageDAO {
    UserDTO getUser(String id);
    List<DogDTO> getDog(String id);
}
