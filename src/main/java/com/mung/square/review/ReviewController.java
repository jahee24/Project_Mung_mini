package com.mung.square.review;

import com.mung.square.dto.ReviewDTO;
import com.mung.square.dto.ReviewFileDTO;
import com.mung.square.dto.ReviewResponseDTO;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/support/review")
@RequiredArgsConstructor
public class ReviewController {
    private final ReviewService service;
    private final FileUploadService fileUploadService;

    @GetMapping("/list")
    public String list(Model model, String category) {
        if (category == null || category.isEmpty()) {
            category = "all"; // 기본값 설정
        }

        List<ReviewResponseDTO> reviewlist = service.findByCategory(category);

        for (ReviewResponseDTO review : reviewlist) {
            List<ReviewFileDTO> reviewFileList = service.getFileList(review.getReviewNo());
            review.setFileMetadata(reviewFileList);
        }

        model.addAttribute("reviewlist", reviewlist);
        model.addAttribute("category", category);
        return "include/reviewlist";
    }

    @GetMapping("/write")
    public String writePage(Model model, HttpSession session) {
        String userId = (String) session.getAttribute("userId");
        if (userId == null) {
            return "redirect:/login";
        }
        model.addAttribute("username", userId);
        return "review/review_write";
    }

    @PostMapping("/write")
    public String insert(ReviewDTO review, HttpSession session) throws IOException {
        String userId = (String) session.getAttribute("userId");
        review.setId(userId);

        int result = service.insertReview(review);
        String reviewNo = review.getReviewNo();

        List<MultipartFile> files = review.getFiles();
        if (files != null && !files.isEmpty()) {
            List<ReviewFileDTO> reviewFileList = new ArrayList<>();
            for (MultipartFile file : files) {
                if (file.isEmpty()) {
                    continue;
                }
                ReviewFileDTO fileDTO = fileUploadService.uploadFile(file);
                fileDTO.setReviewNo(reviewNo);
                reviewFileList.add(fileDTO);
            }
            service.saveReviewFiles(reviewFileList);
        }

        return "redirect:/support/review/list?category=all";
    }

    @PostMapping("/search")
    public String search(String tag, String search, Model model) {
        if (tag == null || tag.isEmpty() || search == null || search.isEmpty()) {
            model.addAttribute("error", "검색 조건을 입력해주세요.");
            return "include/reviewlist";
        }

        List<ReviewResponseDTO> reviewList = service.search(tag, search);
        model.addAttribute("reviewlist", reviewList);
        return "include/reviewlist";
    }

    @GetMapping("/read")
    public String read(String reviewNo, String action, Model model) {
        ReviewDTO review = service.getReviewInfo(reviewNo);
        // SQL을 통해 store_filename 가져오기
        List<String> storeFilenames = service.getStoreFilenamesByReviewNo(reviewNo);

        // 파일 경로 생성
        List<String> fileUrls = new ArrayList<>();
        for (String storeFilename : storeFilenames) {
            fileUrls.add("/fullstack7/downloads/" + storeFilename);
        }
        model.addAttribute("review", review);
        model.addAttribute("fileUrls", fileUrls);
        if ("READ".equals(action)) {
            System.out.println(review.getFileMetadata());
            return "review/review_read";
        } else {
            return "review/review_update";
        }
    }

    @PostMapping("/update")
    public String update(ReviewDTO review) {
        service.update(review);
        return "redirect:/support/review/list?category=all";
    }

    @PostMapping("/delete")
    public String delete(String reviewNo) {
        service.delete(reviewNo);
        return "redirect:/support/review/list?category=all";
    }
}
