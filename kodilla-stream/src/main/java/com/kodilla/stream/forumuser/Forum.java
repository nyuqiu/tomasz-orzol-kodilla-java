package com.kodilla.stream.forumuser;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public final class Forum {

    public static List<ForumUser> getUserList() {

        Random random = new Random();

        final List<ForumUser> userList = new ArrayList<>();
        for(int i=0; i<40; i++){
            int id = i;
            String userName = "username"+random.nextInt(100);
            char sex ='A';
            if(random.nextInt(1)==0){
                sex = 'M';
            } else {
                sex = 'F';
            }
            int year = 1900+random.nextInt(117);
            int month = random.nextInt(11);
            int day=0;
            if(year%4==2){
                day = random.nextInt(27);
            } else {
                day = random.nextInt(29);
            }
            LocalDate dateOfBirtt = LocalDate.of(year, month+1, day+1);
            int postCount = random.nextInt(200);
            userList.add(new ForumUser(id, userName, sex, dateOfBirtt, postCount));
        }
        return new ArrayList<>(userList);
    }
}
