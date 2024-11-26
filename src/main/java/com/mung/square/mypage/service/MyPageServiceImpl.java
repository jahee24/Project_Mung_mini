package com.mung.square.mypage.service;

import com.mung.square.dto.DogDTO;
import com.mung.square.dto.UserDTO;
import com.mung.square.mypage.dao.MyPageDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MyPageServiceImpl implements MyPageService {
    private final MyPageDAO myPageDAO;
    public UserDTO getUser(String id){
        return myPageDAO.getUser(id);
    };
    public List<DogDTO> getDog(String id){
        return myPageDAO.getDog(id);
    };
}
