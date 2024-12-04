package com.mung.square.review;

import com.mung.square.dto.ReviewDTO;
import com.mung.square.dto.ReviewFileDTO;
import com.mung.square.dto.ReviewResponseDTO;

import java.util.List;

public interface ReviewDAO {
	// 게시글 등록
	int insert(ReviewDTO review);

	// 게시글 목록 보기
	List<ReviewResponseDTO> reviewList();

	// 게시글 상세 조회
	ReviewDTO read(String review_no);

	// 게시글 수정
	int update(ReviewDTO review);

	// 게시글 삭제
	int delete(String review_no);

	// 제목, 작성자, 본문, 작성일별로 검색
	List<ReviewResponseDTO> search(String tag, String data);

	// 카테고리별로 검색
	List<ReviewResponseDTO> findByCategory(String category);

	// ================= 첨부파일을 관리하기 위한 기능 =================

	// 첨부파일 저장
	int insertFile(ReviewFileDTO reviewFileDTO); // 개별 파일 저장

	// 여러 개의 첨부파일 저장
	int insertFile(List<ReviewFileDTO> reviewfiledtolist);

	// 특정 게시글의 모든 첨부파일 조회 (게시글 번호 기준)
	List<ReviewFileDTO> getFileList(String reviewNo);

	// 특정 파일 상세 조회 (파일 번호 기준)
	ReviewFileDTO getFile(String reviewFileNo);

	// 특정 게시글의 첨부파일 목록 조회 (중복 메소드 제거)
	List<ReviewFileDTO> getFileListByReviewNo(String reviewno);
	List<String> getStoreFilenamesByReviewNo(String reviewNo);

}