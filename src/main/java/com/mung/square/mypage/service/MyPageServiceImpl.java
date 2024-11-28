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
        System.out.println("service,getUser");
        return myPageDAO.getUser(id);
    };
    public List<DogDTO> getDogList(String id){
        System.out.println("service,getDogList");
        return myPageDAO.getDogList(id);

    }

    @Override
    public DogDTO getDogById(String id) {
        System.out.println(id);
        return myPageDAO.getDogById(id);
    }

    ;
}
