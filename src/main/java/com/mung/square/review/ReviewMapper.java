package com.mung.square.review;

import com.mung.square.dto.ReservationForMypageDTO;
import com.mung.square.dto.ReviewDTO;
import com.mung.square.dto.ReviewFileDTO;
import com.mung.square.dto.ReviewResponseDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface ReviewMapper {
    // 기존 메소드 유지
    int insert(ReviewDTO review);

    List<ReviewResponseDTO> selectall();

    ReviewDTO read(String reviewNo);

    int update(ReviewDTO review);

    int delete(String review_no);


    int fileinsert(ReviewFileDTO file);

    // 새로 추가된 메소드
    List<ReviewFileDTO> getFileList(String reviewno); // 특정 게시글의 파일 목록 조회

    ReviewFileDTO getFile(String reviewFileno); // 특정 파일 정보 조회

    List<ReviewFileDTO> getFileListByReviewNo(String reviewno); // 특정 게시글의 파일 리스트 조회

    List<ReviewResponseDTO> dynamicsearch(Map<String, String> map);

    List<ReviewResponseDTO> categorySelect(String category);

    List<String> getStoreFilenamesByReviewNo(String reviewNo);
}
