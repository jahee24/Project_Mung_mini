package com.mung.square.notice.Controller;

import com.mung.square.notice.domain.Post;
import com.mung.square.notice.service.PostService;
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
    @Autowired
    private JdbcTemplate jdbcTemplate;


    // 게시글 상세보기
    @GetMapping("/viewpost/{postId}")
    public String viewPost(@PathVariable int postId, Model model) {
        // DB에서 게시글 정보 가져오기
        Post post = postService.getPostById(postId);  // 해당 ID에 맞는 게시글 조회
        model.addAttribute("post", post);  // 게시글을 model에 담아서 Thymeleaf로 전달
        return "board/viewpost";  // 게시글 상세보기 페이지 반환
    }


    //게시글 삭제
    @GetMapping("/deletePost/{postId}")
    public String deletePost(@PathVariable int postId) {
        try {
            postService.deletePost(postId);  // 게시글 삭제
            return "redirect:board/deletepost";  // 삭제 후 목록 페이지로 리다이렉트
        } catch (Exception e) {
            e.printStackTrace();
            return "error";  // 오류 발생 시 에러 페이지로 이동
        }
    }


    // 게시글 목록 조회
    @GetMapping
    public String getAllPosts(@RequestParam(defaultValue = "1") int page,
                              @RequestParam(defaultValue = "10") int size,
                              Model model) {
        // DB에서 공지사항 데이터 가져오기
        List<Post> posts = postService.getAllPosts(page, size);  // postService.getAllPosts는 DB에서 데이터를 가져오는 메서드

        // model에 데이터를 담아 view로 전달
        model.addAttribute("posts", posts);
        return "board/notice";  // 반환할 view (예: board/notice.html)
    }

    //게시판 상세 확인
    //  @GetMapping("/viewpost/{postId}")
    //public String viewPost(@PathVariable int postId, Model model) {
    //  Post post = postService.getPostById(postId);  // 해당 ID에 맞는 게시글 조회
    //model.addAttribute("post", post);
    //return "board/viewpost";  // 게시글 상세보기 페이지 반환
    // }

    // 새글 작성 페이지로 이동
    @GetMapping("/newPost")
    public String newPost(HttpSession session, Model model) {
        String memberNo = (String) session.getAttribute("member_no"); // 세션에서 member_no 확인

        // 콘솔에 확인용 출력
        System.out.println("member_no from session: " + memberNo);

        if (memberNo != null && memberNo.startsWith("m")) {
            return "board/NewPost";  // 매니저인 경우 글쓰기 페이지로 이동
        } else {
            return "redirect:/support/notice";  // 비회원은 게시판으로 리다이렉트
        }
    }
}
    /*@Controller
    public class LoginController {

        @Autowired
        private JdbcTemplate jdbcTemplate;

        @PostMapping("/login")
        public String login(@RequestParam String userId, @RequestParam String password, HttpSession session, Model model) {
            // 로그인 인증 로직 (비밀번호 확인 등)
            boolean isAuthenticated = authenticateUser(userId, password);

            if (isAuthenticated) {
                // 인증 성공: DB에서 member_no를 가져오기
                String sql = "SELECT member_no FROM User WHERE user_id = ?";
                String memberNo = jdbcTemplate.queryForObject(sql, String.class, userId);

                // 세션에 member_no 저장
                if (memberNo != null) {
                    session.setAttribute("member_no", memberNo);
                    session.setAttribute("user_id", userId);  // user_id도 세션에 저장
                }

                // 로그인 성공 후 원하는 페이지로 리다이렉트
                return "redirect:/support/notice";  // 게시판으로 리다이렉트
            } else {
                model.addAttribute("error", "Invalid username or password");
                return "login";  // 로그인 페이지로 돌아가기
            }
        }

        private boolean authenticateUser(String userId, String password) {
            // 로그인 인증 로직 (단순 예시)
            String sql = "SELECT password FROM User WHERE user_id = ?";
            String storedPassword = jdbcTemplate.queryForObject(sql, String.class, userId);

            return storedPassword != null && storedPassword.equals(password);  // 비밀번호 비교
        }
    }



   */




