package com.mung.square.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.Alias;

import java.sql.Date;
import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Alias("reviewnreservation")
public class ReviewNReservationDTO {
    private String reviewNo;
    private String userId;
    private List<ReviewFileDTO> files;
    private String reviewFileNo;//식별할 수 있는 번호
    private String fileUrl; // 이미지 접근용 URL 추가
}
