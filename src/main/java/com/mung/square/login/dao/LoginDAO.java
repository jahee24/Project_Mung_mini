package com.mung.square.login.dao;

import com.mung.square.dto.LoginDTO;
import com.mung.square.dto.UserDTO;

public interface LoginDAO {
    UserDTO login(LoginDTO loginUser);

}
