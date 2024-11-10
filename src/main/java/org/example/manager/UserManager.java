package org.example.manager;

import org.example.data.Post;
import org.example.data.User;

import java.util.ArrayList;
import java.util.List;

public class UserManager {
    private List<User> userList;
    public UserManager(){
        this.userList = new ArrayList<>();
    }

    public List<User> getUserList() {
        return userList;
    }

    public void registerUser(Integer userId, String username) throws Exception {
        try {
            if (this.userList.size() != 0) {
                for (User user : this.userList) {
                    if (user.getUserId().equals(userId)) throw new RuntimeException("User "+username+" Already exists");
                }
            }
            User newUser = new User(userId, username);
            userList.add(newUser);
            return;
        }
        catch (Exception e) {
//            System.out.println(e);
            throw new Exception(e.getMessage());
        }
    }

    public void handleFollowUnfollowAction(String actionType, int srcUserId, int destUserId) throws Exception {
        User destUser = null;
        User srcUser = null;

        for(User user:this.userList){
            if(user.getUserId() == destUserId){
                destUser = user;
            }
            if(user.getUserId() == srcUserId){
                srcUser = user;
            }
        }
        if(destUser == null || srcUser == null){
            throw new Exception("User Not Found");
        }

        if(actionType.equals("FOLLOW")){
            srcUser.setFollowing(destUser);
            System.out.println("Followed "+destUser.getUserName());
        }
        if(actionType.equals("UNFOLLOW")){
            //But if user is already UNFOLLOWING then what?
            srcUser.getFollowing().remove(destUser);
            System.out.println("Unfollowed "+destUser.getUserName());
        }

    }

    public void showFeed(Integer userId) throws Exception {

        User inputUser = null;

        for(User user:this.userList){
            if(user.getUserId() == userId){
                inputUser = user;
                break;
            }
        }
        if(inputUser == null){
            throw new Exception("User Not Found");
        }

        System.out.println("Username "+inputUser.getUserName());
        List<Post> postList = inputUser.getPosts();

        if(!postList.isEmpty()){
            for (Post post:postList){
                System.out.println("# of Likes -"+post.getLikes());
                System.out.println("# of Dislikes -"+post.getDislikes());
                System.out.println("Post - "+post.getPost());
                System.out.println("Post time -"+post.getDateTime());
            }
        }
        else{
            System.out.println("No posts to show for user "+inputUser.getUserName());
        }

    }
}
