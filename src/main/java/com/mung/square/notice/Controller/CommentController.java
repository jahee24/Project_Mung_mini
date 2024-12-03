package com.mung.square.notice.Controller;

import com.mung.square.notice.domain.Comment;
import com.mung.square.notice.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/comments")
public class CommentController {

    @Autowired
    private PostService postService;

    // 댓글 추가
    @PostMapping("/add")
    public ResponseEntity<Comment> addComment(@RequestBody Comment comment) {
        try {
            postService.addComment(comment.getPostId(), comment);  // 댓글 추가
            return new ResponseEntity<>(comment, HttpStatus.CREATED);  // 댓글이 생성된 객체를 반환
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);  // 오류 처리
        }
    }



    // 댓글 삭제
    @DeleteMapping("/delete/{commentId}")
    public ResponseEntity<Void> deleteComment(@PathVariable int commentId) {
        try {
            postService.deleteComment(commentId);  // 댓글 삭제
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);  // 삭제 성공, no content 상태 반환
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);  // 오류 처리
        }
    }





}