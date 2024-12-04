package com.mung.square.review;

import com.mung.square.dto.ReservationForMypageDTO;
import com.mung.square.dto.ReviewDTO;
import com.mung.square.dto.ReviewFileDTO;
import com.mung.square.dto.ReviewResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService {
    private final ReviewDAO reviewDAO;

    @Override
    public int insert(ReviewDTO review, List<ReviewFileDTO> reviewfiledtolist) {
        if (reviewfiledtolist == null || reviewfiledtolist.isEmpty()) {
            return reviewDAO.insert(review);
        } else {
            reviewDAO.insert(review); // 게시글 등록
            return reviewDAO.insertFile(reviewfiledtolist); // 첨부파일 등록
        }
    }

    @Override
    public int insert(ReviewDTO review) {
        return reviewDAO.insert(review);
    }

    @Override
    public List<ReviewResponseDTO> reviewList() {
        List<ReviewResponseDTO> reviews = reviewDAO.reviewList(); // 게시글 목록 조회
        for (ReviewResponseDTO review : reviews) {
            List<ReviewFileDTO> files = reviewDAO.getFileListByReviewNo(review.getReviewNo());
            for (ReviewFileDTO file : files) {
                // store_filename을 기반으로 fileUrl 생성
                file.setFileUrl("/fullstack7/downloads/" + file.getStoreFilename());
            }
            review.setFileMetadata(files); // 파일 정보 설정
        }
        return reviews;
    }

    @Override
    public ReviewDTO getReviewInfo(String review_no) {
        return reviewDAO.read(review_no);
    }

    @Override
    public int update(ReviewDTO review) {
        return reviewDAO.update(review);
    }

    @Override
    public int delete(String review_no) {
        return reviewDAO.delete(review_no);
    }

    @Override
    public List<ReviewResponseDTO> search(String tag, String data) {
        return reviewDAO.search(tag, data); // DAO 호출로 수정
    }

    @Override
    public List<ReviewResponseDTO> findByCategory(String category) {
        if (category == null || category.equalsIgnoreCase("all")) {
            return reviewDAO.reviewList(); // 모든 게시글 반환
        } else {
            return reviewDAO.findByCategory(category); // 특정 카테고리 반환
        }
    }

    @Override
    public List<ReviewFileDTO> getFileList(String reviewno) {
        return reviewDAO.getFileListByReviewNo(reviewno);
    }

    @Override
    public ReviewFileDTO getFile(String reviewFileno) {
        return reviewDAO.getFile(reviewFileno);
    }

    @Override
    public int insertReview(ReviewDTO review) {
        return reviewDAO.insert(review);
    }
    @Override
    public List<String> getStoreFilenamesByReviewNo(String reviewNo) {
        return reviewDAO.getStoreFilenamesByReviewNo(reviewNo);
    }

    @Override
    public void saveReviewFiles(List<ReviewFileDTO> reviewFileList) {
        for (ReviewFileDTO fileDTO : reviewFileList) {
            reviewDAO.insertFile(fileDTO);
        }
    }

    @Override
    public List<ReservationForMypageDTO> needReviewResvList(String userId) {
        return reviewDAO.needReviewResvList(userId);
    }
}
