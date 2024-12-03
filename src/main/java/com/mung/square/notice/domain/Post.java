package com.mung.square.notice.domain;

import java.sql.Timestamp;

public class Post {
    private int postId;
    private String postTitle;
    private String postContent;
    private String postAuthor;  // 작성자 이름
    private int postViews;
    private String postAuthorId; // 변경된 타입: String (user_id와 일치)
    private Timestamp postCreatedAt;
    // 기존 getter와 setter들
    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public String getPostTitle() {
        return postTitle;
    }

    public void setPostTitle(String postTitle) {
        this.postTitle = postTitle;
    }

    public String getPostContent() {
        return postContent;
    }

    public void setPostContent(String postContent) {
        this.postContent = postContent;
    }

    public String getPostAuthor() {
        return postAuthor;
    }

    public void setPostAuthor(String postAuthor) {
        this.postAuthor = postAuthor;
    }

    public int getPostViews() {
        return postViews;
    }

    public void setPostViews(int postViews) {
        this.postViews = postViews;
    }

    public String getPostAuthorId() {   // 변경된 getter
        return postAuthorId;
    }

    public void setPostAuthorId(String postAuthorId) {  // 변경된 setter
        this.postAuthorId = postAuthorId;
    }

    // 생성일시 setter
    public void setPostCreatedAt(Timestamp postCreatedAt) {
        this.postCreatedAt = postCreatedAt;
    }

    // 생성일시 getter
    public Timestamp getPostCreatedAt() {
        return postCreatedAt;
    }





}
