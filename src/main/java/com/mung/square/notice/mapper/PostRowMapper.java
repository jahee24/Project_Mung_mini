package com.mung.square.notice.mapper;

import com.mung.square.notice.domain.Post;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PostRowMapper implements RowMapper<Post> {
    @Override
    public Post mapRow(ResultSet rs, int rowNum) throws SQLException {
        Post post = new Post();
        post.setPostId(rs.getInt("post_id"));
        post.setPostTitle(rs.getString("post_title"));
        post.setPostContent(rs.getString("post_content"));
        post.setPostAuthor(rs.getString("post_author"));
        post.setPostViews(rs.getInt("post_views"));
        // 필요한 다른 필드도 설정해 주세요.
        return post;
    }
}
