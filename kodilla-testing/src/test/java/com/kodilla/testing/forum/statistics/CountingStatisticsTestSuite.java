package com.kodilla.testing.forum.statistics;

import org.junit.*;

import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CountingStatisticsTestSuite {

    private static int testCounter = 0;

    @BeforeClass
    public static void beforeAllTests() {
        System.out.println("This is the beginning of tests.");
    }

    @AfterClass
    public static void afterAllTests() {
        System.out.println("All tests are finished.");
    }

    @Before
    public void beforeEveryTest() {
        testCounter++;
        System.out.println("Preparing to execute test #" + testCounter);
    }

    @Test
    public void testCalculateAverageOfPostsPerUsers1000per100WithMock() {
        //Given
        Statistics statisticsMock = mock(Statistics.class);
        List<String> userAmount = mock(List.class);
        when(userAmount.size()).thenReturn(100);
        int postCount = 1000;
        when(statisticsMock.usersNames()).thenReturn(userAmount);
        when(statisticsMock.postsCount()).thenReturn(postCount);

        StatisticsCalculator countingStatistics = new StatisticsCalculator(statisticsMock);
        countingStatistics.calculateAdvStatistics(statisticsMock);

        //When
        double average = countingStatistics.getAverageAmountOfPostsPerUser();

        //Then
        Assert.assertEquals((Double) 10.0, (Double) average);
    }

    @Test
    public void testCalculateAverageOfPostsPerUsers0per100WithMock() {
        //Given
        Statistics statisticsMock = mock(Statistics.class);
        List<String> userAmount = mock(List.class);
        when(userAmount.size()).thenReturn(100);
        int postCount = 0;
        when(statisticsMock.usersNames()).thenReturn(userAmount);
        when(statisticsMock.postsCount()).thenReturn(postCount);

        StatisticsCalculator countingStatistics = new StatisticsCalculator(statisticsMock);
        countingStatistics.calculateAdvStatistics(statisticsMock);

        //When
        double average = countingStatistics.getAverageAmountOfPostsPerUser();

        //Then
        Assert.assertEquals((Double) 0.0, (Double) average);
    }

    @Test
    public void testCalculateAverageOfPostsPerUsers0per0WithMock() {
        //Given
        Statistics statisticsMock = mock(Statistics.class);
        List<String> userAmount = mock(List.class);
        when(userAmount.size()).thenReturn(0);
        int postCount = 0;
        when(statisticsMock.usersNames()).thenReturn(userAmount);
        when(statisticsMock.postsCount()).thenReturn(postCount);

        StatisticsCalculator countingStatistics = new StatisticsCalculator(statisticsMock);
        countingStatistics.calculateAdvStatistics(statisticsMock);

        //When
        double average = countingStatistics.getAverageAmountOfPostsPerUser();

        //Then
        Assert.assertEquals((Double) (0.0 / 0.0), (Double) average);
    }

    @Test
    public void testCalculateAverageOfPostsPerUsers1000per0WithMock() {
        //Given
        Statistics statisticsMock = mock(Statistics.class);
        List<String> userAmount = mock(List.class);
        when(userAmount.size()).thenReturn(0);
        int postCount = 1000;
        when(statisticsMock.usersNames()).thenReturn(userAmount);
        when(statisticsMock.postsCount()).thenReturn(postCount);

        StatisticsCalculator countingStatistics = new StatisticsCalculator(statisticsMock);
        countingStatistics.calculateAdvStatistics(statisticsMock);

        //When
        double average = countingStatistics.getAverageAmountOfPostsPerUser();

        //Then
        Assert.assertEquals((Double) (1000 / 0.0), (Double) average);
    }

    @Test
    public void testCalculateAverageOfCommentsPerPosts100per1000WithMock() {
        //Given
        Statistics statisticsMock = mock(Statistics.class);
        int commentCount = 100;
        int postCount = 1000;
        when(statisticsMock.commentsCount()).thenReturn(commentCount);
        when(statisticsMock.postsCount()).thenReturn(postCount);

        StatisticsCalculator countingStatistics = new StatisticsCalculator(statisticsMock);
        countingStatistics.calculateAdvStatistics(statisticsMock);

        //When
        double average = countingStatistics.getAverageAmountOfCommentsPerPost();

        //Then
        Assert.assertEquals((Double) (100.0 / 1000), (Double) average);
    }

    @Test
    public void testCalculateAverageOfCommentsPerPosts1000per0WithMock() {
        //Given
        Statistics statisticsMock = mock(Statistics.class);
        int commentCount = 100;
        int postCount = 0;
        when(statisticsMock.commentsCount()).thenReturn(commentCount);
        when(statisticsMock.postsCount()).thenReturn(postCount);

        StatisticsCalculator countingStatistics = new StatisticsCalculator(statisticsMock);
        countingStatistics.calculateAdvStatistics(statisticsMock);

        //When
        double average = countingStatistics.getAverageAmountOfCommentsPerPost();

        //Then
        Assert.assertEquals((Double) (1000.0 / 0), (Double) average);
    }

    @Test
    public void testCalculateAverageOfCommentsPerPosts0per0WithMock() {
        //Given
        Statistics statisticsMock = mock(Statistics.class);
        int commentCount = 0;
        int postCount = 0;
        when(statisticsMock.commentsCount()).thenReturn(commentCount);
        when(statisticsMock.postsCount()).thenReturn(postCount);

        StatisticsCalculator countingStatistics = new StatisticsCalculator(statisticsMock);
        countingStatistics.calculateAdvStatistics(statisticsMock);

        //When
        double average = countingStatistics.getAverageAmountOfCommentsPerPost();

        //Then
        Assert.assertEquals((Double) (0.0 / 0), (Double) average);
    }

    @Test
    public void testCalculateAverageOfCommentsPerPosts0per1000WithMock() {
        //Given
        Statistics statisticsMock = mock(Statistics.class);
        int commentCount = 0;
        int postCount = 1000;
        when(statisticsMock.commentsCount()).thenReturn(commentCount);
        when(statisticsMock.postsCount()).thenReturn(postCount);

        StatisticsCalculator countingStatistics = new StatisticsCalculator(statisticsMock);
        countingStatistics.calculateAdvStatistics(statisticsMock);

        //When
        double average = countingStatistics.getAverageAmountOfCommentsPerPost();

        //Then
        Assert.assertEquals((Double) (0.0 / 100), (Double) average);
    }

    @Test
    public void testCalculateAverageOfCommentsPerUsers0per100WithMock() {
        //Given
        Statistics statisticsMock = mock(Statistics.class);
        List<String> userAmount = mock(List.class);
        when(statisticsMock.usersNames()).thenReturn(userAmount);
        when(userAmount.size()).thenReturn(0);
        int commentCount = 100;
        when(statisticsMock.commentsCount()).thenReturn(commentCount);


        StatisticsCalculator countingStatistics = new StatisticsCalculator(statisticsMock);
        countingStatistics.calculateAdvStatistics(statisticsMock);

        //When
        double average = countingStatistics.getAverageAmountOfCommentsPerUser();

        //Then
        Assert.assertEquals((Double) (100 / 0.0), (Double) average);
    }

    @Test
    public void testCalculateAverageOfCommentsPerUsers1000per100WithMock() {
        //Given
        Statistics statisticsMock = mock(Statistics.class);
        List<String> userAmount = mock(List.class);
        when(statisticsMock.usersNames()).thenReturn(userAmount);
        when(userAmount.size()).thenReturn(100);
        int commentCount = 1000;
        when(statisticsMock.commentsCount()).thenReturn(commentCount);

        StatisticsCalculator countingStatistics = new StatisticsCalculator(statisticsMock);
        countingStatistics.calculateAdvStatistics(statisticsMock);

        //When
        double average = countingStatistics.getAverageAmountOfCommentsPerUser();

        //Then
        Assert.assertEquals((Double) (1000.0 / 100.0), (Double) average);
    }


    @Test
    public void testCalculateAverageOfCommentsPerUsers0per0WithMock() {
        //Given
        Statistics statisticsMock = mock(Statistics.class);
        List<String> userAmount = mock(List.class);
        when(statisticsMock.usersNames()).thenReturn(userAmount);
        when(userAmount.size()).thenReturn(0);
        int commentCount = 0;
        when(statisticsMock.commentsCount()).thenReturn(commentCount);


        StatisticsCalculator countingStatistics = new StatisticsCalculator(statisticsMock);
        countingStatistics.calculateAdvStatistics(statisticsMock);

        //When
        double average = countingStatistics.getAverageAmountOfCommentsPerUser();

        //Then
        Assert.assertEquals((Double) (0.0 / 0), (Double) average);
    }

    @Test
    public void testCalculateAverageOfCommentsPerUsers1000per0WithMock() {
        //Given
        Statistics statisticsMock = mock(Statistics.class);
        List<String> userAmount = mock(List.class);
        when(statisticsMock.usersNames()).thenReturn(userAmount);
        when(userAmount.size()).thenReturn(0);
        int commentCount = 1000;
        when(statisticsMock.commentsCount()).thenReturn(commentCount);


        StatisticsCalculator countingStatistics = new StatisticsCalculator(statisticsMock);
        countingStatistics.calculateAdvStatistics(statisticsMock);

        //When
        double average = countingStatistics.getAverageAmountOfCommentsPerUser();

        //Then
        Assert.assertEquals((Double) (1000.0 / 0), (Double) average);
    }
}

