package com.mung.square.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.Alias;

import java.sql.Date;
import java.util.UUID;

import static java.lang.Float.parseFloat;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Alias("dog")
public class DogDTO {
	private String id;
	private String name;
	private Date birthDate;
	private String breed;
	private String weight;
	private String gender;
	private String imageUrl;
	private String userId;
	public void generateId() {
		this.setId( userId + "_" + UUID.randomUUID().toString().substring(0, 8));
	}

}
