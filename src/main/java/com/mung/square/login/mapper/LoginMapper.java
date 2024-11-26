package com.mung.square.login.mapper;

import com.mung.square.dto.LoginDTO;
import com.mung.square.dto.UserDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LoginMapper {
    UserDTO login(LoginDTO user);

}
