package com.mung.square.notice.Controller;

import com.mung.square.notice.domain.Post;
import com.mung.square.notice.service.PostService;
import com.mung.square.payment.controller.SessionUtils;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Controller
@RequestMapping("/support/notice")
public class NoticeController {
    @Autowired
    private PostService postService;
    private SessionUtils model;

    //검색 기능
    @GetMapping("/search")
    public String searchPosts(@RequestParam("keyword") String keyword,
                              @RequestParam(defaultValue = "1") int page,
                              @RequestParam(defaultValue = "10") int size,
                              Model model) {
        List<Post> posts = postService.searchPosts(keyword, page, size);
        model.addAttribute("posts", posts);
        return "board/notice";
    }





    // 게시글 상세보기
    @GetMapping("/viewpost/{postId}")
    public String viewPost(@PathVariable int postId, Model model) {
        Post post = postService.getPostById(postId);  // 해당 ID에 맞는 게시글 조회
        model.addAttribute("post", post);  // 게시글을 model에 담아서 Thymeleaf로 전달
        return "board/viewpost";  // 게시글 상세보기 페이지 반환
    }

    // 게시글 목록 조회
    @GetMapping
    public String getAllPosts(@RequestParam(defaultValue = "1") int page,
                              @RequestParam(defaultValue = "10") int size,
                              Model model) {
        List<Post> posts = postService.getAllPosts(page, size);  // 게시글 목록 조회
        model.addAttribute("posts", posts);  // model에 데이터를 담아 view로 전달
        return "board/notice";  // 공지사항 목록 페이지 반환
    }

    // 새 글 작성 페이지로 이동
    @GetMapping("/newPost")
    public String newPost(HttpSession session) {
        String memberNo = (String) session.getAttribute("member_no"); // 세션에서 member_no 확인
        String userName = (String) session.getAttribute("userName");
        model.addAttribute("userName", userName);
        if (memberNo != null && memberNo.startsWith("m")) {
            return "board/newPost";  // 매니저인 경우 글쓰기 페이지로 이동
        } else {
            return "redirect:/support/notice";  // 비회원은 게시판으로 리다이렉트
        }
    }
}

