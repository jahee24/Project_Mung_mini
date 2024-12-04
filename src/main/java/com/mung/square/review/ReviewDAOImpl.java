package com.mung.square.review;

import com.mung.square.dto.ReviewDTO;
import com.mung.square.dto.ReviewFileDTO;
import com.mung.square.dto.ReviewResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
@RequiredArgsConstructor
public class ReviewDAOImpl implements ReviewDAO {
    private final ReviewMapper mapper;

    @Override
    public int insert(ReviewDTO review) {
        return mapper.insert(review);
    }

    @Override
    public List<ReviewResponseDTO> reviewList() {
        return mapper.selectall();
    }

    @Override
    public ReviewDTO read(String review_no) {
        return mapper.read(review_no);
    }

    @Override
    public int update(ReviewDTO review) {
        return mapper.update(review);
    }

    @Override
    public int delete(String review_no) {
        return mapper.delete(review_no);
    }

    @Override
    public List<ReviewResponseDTO> search(String tag, String data) {
        Map<String, String> map = new HashMap<>();
        map.put("tag", tag);
        map.put("data", data);
        return mapper.dynamicsearch(map); // Mapper 호출로 수정
    }

    @Override
    public List<ReviewResponseDTO> findByCategory(String category) {
        return mapper.categorySelect(category);
    }

    @Override
    public int insertFile(ReviewFileDTO reviewFileDTO) {
        return mapper.fileinsert(reviewFileDTO);
    }

    @Override
    public int insertFile(List<ReviewFileDTO> reviewfiledtolist) {
        int result = 0;
        for (ReviewFileDTO file : reviewfiledtolist) {
            if (file.getReviewNo() == null) {
                System.err.println("ReviewNo is missing for file: " + file);
                continue;
            }
            result += insertFile(file);
        }
        return result;
    }

    @Override
    public List<ReviewFileDTO> getFileList(String reviewno) {
        return mapper.getFileList(reviewno); // Mapper 호출로 수정
    }

    @Override
    public ReviewFileDTO getFile(String reviewFileno) {
        return mapper.getFile(reviewFileno); // Mapper 호출로 수정
    }

    @Override
    public List<ReviewFileDTO> getFileListByReviewNo(String reviewno) {
        return mapper.getFileListByReviewNo(reviewno); // Mapper 호출로 수정
    }
    @Override
    public List<String> getStoreFilenamesByReviewNo(String reviewNo) {
        return mapper.getStoreFilenamesByReviewNo(reviewNo);
    }

}
