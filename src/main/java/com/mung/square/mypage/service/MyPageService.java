package com.mung.square.mypage.service;

import com.mung.square.dto.DogDTO;
import com.mung.square.dto.UserDTO;

import java.util.List;

public interface MyPageService {
    UserDTO getUser(String id);
    List<DogDTO> getDogList(String id);
    DogDTO getDogById(String id);

}
