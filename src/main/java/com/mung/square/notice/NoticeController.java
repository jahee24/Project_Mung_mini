package com.mung.square.notice;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NoticeController {

    // 공지사항 페이지
    @GetMapping("/support/notice")
    public String notice() {
        return "board/notice"; // templates/board/notice.html 반환
    }

    // 관리자 공지사항 페이지
    @GetMapping("/admin/notice")
    public String adminNotice() {
        return "board/admin_notice"; // templates/board/admin_notice.html 반환
    }

    // 리뷰 페이지
    @GetMapping("/review")
    public String review() {
        return "board/review"; // templates/board/review.html 반환
    }

    // 공지사항 상세 페이지
    @GetMapping("/board/detail")
    public String detail() {
        return "board/detail"; // templates/board/detail.html 반환
    }
}
