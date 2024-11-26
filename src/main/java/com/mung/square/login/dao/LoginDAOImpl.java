package com.mung.square.login.dao;

import com.mung.square.dto.LoginDTO;
import com.mung.square.dto.UserDTO;
import com.mung.square.login.mapper.LoginMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class LoginDAOImpl implements LoginDAO {
    private final LoginMapper loginMapper;
    public UserDTO login(LoginDTO user) {
        return loginMapper.login(user);
    }

}
