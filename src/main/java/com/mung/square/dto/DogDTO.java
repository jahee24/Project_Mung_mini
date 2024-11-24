package com.mung.square.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.Alias;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Alias("dog")
public class DogDTO {
	String id;
	String name;
	Date birth_date;
	String dog_type;
	float weight;
	String sex;
	String user_id;

}
