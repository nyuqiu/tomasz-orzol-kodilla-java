package com.kodilla.testing.forum.statistics;

public class CountingStatistics {
    double averageAmountOfPostsPerUser;
    double averageAmountOfCommentsPerUser;
    double averageAmountOfCommentsPerPost;
    Statistics statistics;

    public CountingStatistics(Statistics statistics) {
        this.statistics = statistics;
        this.averageAmountOfPostsPerUser = 0;
        this.averageAmountOfCommentsPerUser = 0;
        this.averageAmountOfCommentsPerPost = 0;
    }

    public double getAverageAmountOfPostsPerUser() {
        return averageAmountOfPostsPerUser;
    }

    public double getAverageAmountOfCommentsPerUser() {
        return averageAmountOfCommentsPerUser;
    }

    public double getAverageAmountOfCommentsPerPost() {
        return averageAmountOfCommentsPerPost;
    }

    void calculateAdvStatistics(Statistics statistics){
        double amountOfUsers = statistics.usersNames().size();
        double postsCount = statistics.postsCount();
        double commentsCount = statistics.commentsCount();
        averageAmountOfPostsPerUser = postsCount/amountOfUsers;
        averageAmountOfCommentsPerUser = commentsCount/amountOfUsers;
        averageAmountOfCommentsPerPost = commentsCount/postsCount;
    }

    String showStatistic(){
        return null;
    }


}
