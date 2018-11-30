package com.kodilla.stream;

import com.kodilla.stream.forumuser.Forum;
import com.kodilla.stream.forumuser.ForumUser;

import java.util.Map;
import java.util.stream.Collectors;

public class StreamMain {
    public static void main(String[] args) {
        Map<Integer, ForumUser> theResultMapOfUsers =  Forum.getUserList().stream()
                .filter(forumUser -> forumUser.getSex() =='M')
                .filter(forumUser -> forumUser.getDateOfBirth().getYear() <1998)
                .filter(forumUser -> forumUser.getPostCoount()>0)
                .collect(Collectors.toMap(ForumUser::getId, forumUser -> forumUser));

        System.out.println(theResultMapOfUsers);
    }
}