package com.mung.square.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.Alias;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Alias("user")
public class UserDTO {
	private String userId;
	private String email;
	private String password;
	private String name;
	private String phoneNumber;
	private String memberNo;

}
