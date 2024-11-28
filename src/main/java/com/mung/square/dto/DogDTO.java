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
	Date birthDate;
	int age;
	String breed;
	float weight;
	String gender;
	String userId;
	String imageUrl;
}
