package org.example;

import org.example.data.ActionType;
import org.example.data.Post;
import org.example.manager.PostManager;
import org.example.manager.UserManager;

import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        System.out.println("Enter commands as mentioned below");
        // Replace with your file path, example in input.txt file
        String filePath = "";

        UserManager userManager = new UserManager();
        PostManager postManager = new PostManager(userManager);

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {

                System.out.println(line);
                String[] cmd = line.split(" ");

                String action = cmd[0];

                if(action.equals("RegisterUser")){
                    userManager.registerUser(Integer.parseInt(cmd[1]),cmd[2]);
                    System.out.println(cmd[2]+ " registered!!");
                }
                if(action.equals("UploadPost")){
                    Post outputPost = postManager.uploadPost(Integer.parseInt(cmd[1]),cmd[2]);
                    System.out.println("Upload Successful with post id: "+outputPost.getPostId());
                }
                if(action.equals("InteractWithPost")){
                    String actionType = cmd[1];
                    postManager.handleActionOnPost(actionType,Integer.parseInt(cmd[2]),Integer.parseInt(cmd[3]));
                }
                if(action.equals("InteractionWithUser")){
                    String actionType = cmd[1];
                    userManager.handleFollowUnfollowAction(actionType,Integer.parseInt(cmd[2]),Integer.parseInt(cmd[3]));
                }
                if(action.equals("ShowFeed")){
                    userManager.showFeed(Integer.parseInt(cmd[1]));
                }




            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}