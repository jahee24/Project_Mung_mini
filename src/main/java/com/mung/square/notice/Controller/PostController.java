package com.mung.square.notice.Controller;

import com.mung.square.notice.domain.Post;
import com.mung.square.notice.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/support/notice") // 경로 수정
public class PostController {

    @Autowired
    private PostService postService;


    // 게시글 작성
    @PostMapping("/newPost")  // 경로 수정
    public String createPost(@RequestParam String title, @RequestParam String content) {
        Post newPost = new Post();
        System.out.println(newPost);
        newPost.setPostTitle(title);
        newPost.setPostContent(content);
        postService.createPost(newPost);
        return "redirect:/support/notice"; // 게시글 작성 후 목록 페이지로 리다이렉트
    }
}
