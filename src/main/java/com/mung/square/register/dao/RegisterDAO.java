package com.mung.square.register.dao;

import com.mung.square.dto.LoginDTO;
import com.mung.square.dto.UserDTO;

public interface RegisterDAO {
    void register(UserDTO registerUser);

}
