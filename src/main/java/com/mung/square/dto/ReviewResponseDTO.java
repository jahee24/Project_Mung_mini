package com.mung.square.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.Alias;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Alias("reviewresponse")
public class ReviewResponseDTO {
    private String reviewNo;
    private String title;
    private String userId;
    private String writeDate;
    private List<ReviewFileDTO> fileMetadata;
}

