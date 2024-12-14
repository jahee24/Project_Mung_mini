package com.mung.square.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.Alias;
import org.springframework.web.multipart.MultipartFile;

import java.sql.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Alias("review")
//request용dto
public class ReviewDTO {
	String reviewNo;
	String userId;
	Date writeDate;
	String title;
	String content;
	String category;
	String resvNum;
	List<MultipartFile> files; // 타입 변경
	List<ReviewFileDTO> fileMetadata;
}
