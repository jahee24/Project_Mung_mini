package com.mung.square.review;

import com.mung.square.dto.ReservationForMypageDTO;
import com.mung.square.dto.ReviewDTO;
import com.mung.square.dto.ReviewFileDTO;
import com.mung.square.dto.UserDTO;
import com.mung.square.mypage.service.MyPageService;
import com.mung.square.dto.ReviewResponseDTO;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
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

    //데이터베이스에서 조회한 게시글 목록을 출력
    //전체목록보기와 카테고리별로 조회하는 작업은 비슷한 작업이므로 컨트롤러를 같이 사용
    @GetMapping("/list")
    public String list(Model model, String category, @SessionAttribute(value = "user", required = false) UserDTO user) {
        if (category == null || category.isEmpty()) {
            category = "all"; // 기본값 설정
            }
        if (user != null) {
            String userId = user.getUserId(); // 세션에서 로그인 사용자 ID 가져오기
            List<ReservationForMypageDTO> reservationForMypageDTO = service.needReviewResvList(userId);
            model.addAttribute("simpleResv", reservationForMypageDTO);
        }

            System.out.println("category=>" + category);
            //1. service의 메소드를 호출(비지니스메소드호출)
            List<ReviewResponseDTO> reviewlist = service.findByCategory(category);
            //2. select작업은 db에서 받은 결과를 뷰로 넘겨주어야 하므로 데이터를 공유
        for (ReviewResponseDTO review : reviewlist) {
            List<ReviewFileDTO> files = service.getFileList(review.getReviewNo());
            if (files != null && !files.isEmpty()) {
                review.setFileMetadata(files);
                for (ReviewFileDTO file : files) {
                    file.setFileUrl("/fullstack7/downloads/"+file.getStoreFilename());
                    System.out.println("File URL: " + file.getFileUrl());
                }
            } else {
                review.setFileMetadata(new ArrayList<>());
                System.out.println("No files found for review: " + review.getReviewNo());
            }

    }
            model.addAttribute("reviewlist", reviewlist);
            model.addAttribute("category", category);
            System.out.println(reviewlist);

            return "include/reviewlist";

    }

    @GetMapping("/write")
    public String writePage(Model model, HttpSession session) {
        String userId = (String) session.getAttribute("userId"); // 세션에서 로그인 사용자 ID 가져오기
        List<ReservationForMypageDTO> simpleResv = service.needReviewResvList(userId);
        if (simpleResv.size()==0) {
            return "redirect:/support/review/list?category=all"; // 로그인 페이지로 리다이렉트
        }
        model.addAttribute("userId", userId);
        return "review/review_write";
    }

    @PostMapping("/write")
    public String insert(ReviewDTO review, HttpSession session) throws IOException {
        String userId = (String) session.getAttribute("userId");
        review.setUserId(userId);

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
    public String read(@RequestParam("reviewNo") String reviewNo, @RequestParam("action") String action, Model model) {
        System.out.println("Received reviewNo: " + reviewNo);

        // 리뷰 정보 조회
        ReviewDTO review = service.getReviewInfo(reviewNo);

        // 첨부 파일 정보 조회
        List<ReviewFileDTO> files = service.getFileList(reviewNo);
        if (files != null && !files.isEmpty()) {
            review.setFileMetadata(files);
            for (ReviewFileDTO file : files) {
                file.setFileUrl("/fullstack7/downloads/" + file.getStoreFilename());
                System.out.println("Generated File URL: " + file.getFileUrl());
            }
        } else {
            review.setFileMetadata(new ArrayList<>());
            System.out.println("No files found for review: " + reviewNo);
        }

        model.addAttribute("review", review);
        if ("READ".equals(action)) {
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


    @GetMapping("/update")
    public String showUpdateForm(String reviewNo, Model model) {
        ReviewDTO review = service.getReviewInfo(reviewNo);
        model.addAttribute("review", review);
        return "review/review_update";
    }

    @PostMapping("/delete")
    public String delete(String reviewNo) {
        System.out.println("Deleting review with reviewNo: " + reviewNo);
        service.delete(reviewNo); // 서비스 계층 호출
        return "redirect:/support/review/list?category=all"; // 목록 페이지로 리다이렉트
    }

    @GetMapping("/delete")
    public String showDeleteErrorPage() {
        return "errorPage"; // 에러 페이지 또는 경고 메시지 표시

    }
}
