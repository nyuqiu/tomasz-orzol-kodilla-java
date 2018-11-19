package com.kodilla.stream.forumuser;

import java.time.LocalDate;
import java.util.Objects;

public final class ForumUser {
    private int id;
    private String userName;
    private char sex;
    private LocalDate dateOfBirth;
    private int postCoount;

    public ForumUser(int id, String userName, char sex, LocalDate dateOfBirth, int postCoount) {
        this.id = id;
        this.userName = userName;
        if(sex=='M' || sex =='F'){
            this.sex = sex;
        }
        this.dateOfBirth = dateOfBirth;
        this.postCoount = postCoount;
    }

    public int getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public char getSex() {
        return sex;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public int getPostCoount() {
        return postCoount;
    }

    @Override
    public String toString() {
        return "ForumUser{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", sex=" + sex +
                ", dateOfBirth=" + dateOfBirth +
                ", postCoount=" + postCoount +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
