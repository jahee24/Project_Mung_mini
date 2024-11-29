package com.mung.square.notice.Controller;

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
    //새글작성
    @GetMapping("/newPost")
    public String newPost() {
        return "board/NewPost"; // templates/board/NewPost.html 반환
    }
    //글 상세 보기
    @GetMapping("/viewPost")
    public String viewPost() {
        return "board/viewPost"; // templates/board/viewPost.html 반환
    }


}
