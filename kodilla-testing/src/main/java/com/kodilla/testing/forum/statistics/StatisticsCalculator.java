package com.kodilla.testing.forum.statistics;

public class StatisticsCalculator {
    private double averageAmountOfPostsPerUser;
    private double averageAmountOfCommentsPerUser;
    private double averageAmountOfCommentsPerPost;
    Statistics statistics;

    public StatisticsCalculator(Statistics statistics) {
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
        String result = "Forum statistics: average of comments per user "+getAverageAmountOfCommentsPerUser()+"\n"+
                ", average of comments per post "+getAverageAmountOfCommentsPerPost()+"\n"+
                ", average of posts per user "+getAverageAmountOfPostsPerUser()+"\n";
        return result;
    }


}
