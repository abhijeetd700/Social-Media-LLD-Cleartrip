package org.example.data;

import java.util.ArrayList;
import java.util.List;

public class User {

    private final Integer userId;
    private final String userName;
    private List<Post> posts;
    private List<User> followers;
    private List<User> following;

    public User(Integer userId, String userName) {
        this.userId = userId;
        this.userName = userName;
        this.posts = new ArrayList<>();
        this.followers = new ArrayList<>();
        this.following = new ArrayList<>();
    }

    public Integer getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(Post posts) {
        this.posts.add(posts);
    }

    public List<User> getFollowers() {
        return followers;
    }

    public void setFollowers(List<User> followers) {
        this.followers = followers;
    }

    public List<User> getFollowing() {
        return following;
    }

    public void setFollowing(User user) {
        this.following.add(user);
    }
}
