package com.mung.square.notice.domain;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
@Getter
@Setter

public class PostComment {


    private int id; // 댓글 ID
    private int postId; // 게시글 ID
    private String content; // 댓글 내용
    private String author; // 작성자
    private LocalDateTime createdAt; // 작성일

}