package com.mung.square.notice.domain;

import lombok.*;

import java.sql.Timestamp;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Post {
    private int postId;
    private String postTitle;
    private String postContent;
    private String postAuthor;  // 작성자 이름
    private int postViews;
    private String postAuthorId; // 변경된 타입: String (user_id와 일치)
    private Timestamp postCreatedAt;
}
