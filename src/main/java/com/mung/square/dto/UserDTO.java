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
	String id;
	String password;
	String name;
	String home_address;
	String phone_number;
	String marketing_consent;
	String membership_status;
	String branch_division;
	String is_member_retired;
	Date birth_date;

}
