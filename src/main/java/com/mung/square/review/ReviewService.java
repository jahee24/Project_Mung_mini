package com.mung.square.review;


import com.mung.square.dto.ReservationForMypageDTO;

import com.mung.square.dto.ReviewDTO;
import com.mung.square.dto.ReviewFileDTO;
import com.mung.square.dto.ReviewResponseDTO;

import java.util.List;

public interface ReviewService {
	int insert(ReviewDTO review, List<ReviewFileDTO> reviewfiledtolist);

	int insert(ReviewDTO review);

	List<ReviewResponseDTO> reviewList();

	ReviewDTO getReviewInfo(String review_no);

	int update(ReviewDTO review);

	int delete(String review_no);


	List<ReviewResponseDTO> search(String tag, String data);

	List<ReviewResponseDTO> findByCategory(String category);

	List<ReviewFileDTO> getFileList(String reviewno);

	ReviewFileDTO getFile(String reviewFileno);

    List<ReservationForMypageDTO> needReviewResvList(String userId);


	int insertReview(ReviewDTO review);

	void saveReviewFiles(List<ReviewFileDTO> reviewFileList);
	List<String> getStoreFilenamesByReviewNo(String reviewNo);

}
