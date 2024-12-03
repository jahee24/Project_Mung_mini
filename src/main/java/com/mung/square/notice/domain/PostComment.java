package com.mung.square.notice.domain;

import java.time.LocalDateTime;

public class PostComment {

    private int id; // 댓글 ID
    private int postId; // 게시글 ID
    private String content; // 댓글 내용
    private String author; // 작성자
    private LocalDateTime createdAt; // 작성일

    // Getter, Setter

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
