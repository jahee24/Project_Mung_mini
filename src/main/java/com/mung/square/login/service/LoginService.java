package com.mung.square.login.service;

import com.mung.square.dto.LoginDTO;
import com.mung.square.dto.UserDTO;

public interface LoginService {
    UserDTO login(LoginDTO loginUser);
}
