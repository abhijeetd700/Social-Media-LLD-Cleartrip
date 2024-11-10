package org.example.data;

import java.time.LocalDateTime;

public class Post {

    private final Integer postId;
    private final String postContent;
    private Integer likes;
    private Integer dislikes;
    private final LocalDateTime dateTime;

    public Post(Integer postId, String postContent) {
        this.postId = postId;
        this.postContent = postContent;
        this.likes = 0;
        this.dislikes = 0;
        this.dateTime = LocalDateTime.now();
    }

    public Integer getPostId() {
        return postId;
    }

    public String getPost() {
        return postContent;
    }

    public Integer getLikes() {
        return likes;
    }

    public void setLikes(Integer likes) {
        this.likes = likes;
    }

    public Integer getDislikes() {
        return dislikes;
    }

    public void setDislikes(Integer dislikes) {
        this.dislikes = dislikes;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }
}
