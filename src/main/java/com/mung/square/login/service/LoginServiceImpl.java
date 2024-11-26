package com.mung.square.login.service;

import com.mung.square.dto.LoginDTO;
import com.mung.square.dto.UserDTO;
import com.mung.square.login.dao.LoginDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginServiceImpl implements LoginService {
    private final LoginDAO loginDAO;
    @Override
    public UserDTO login(LoginDTO loginUser) {
        UserDTO user = loginDAO.login(loginUser);
        return user;
    }
}
