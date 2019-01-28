package com.kodilla.patterns.factory.tasks;

import org.junit.Assert;
import org.junit.Test;

public class TaskFactoryTestSuite {

    @Test
    public void testFactoryShoppingTask() {
        //Given
        TaskFactory taskFactory = new TaskFactory();
        ListOfExecutedTasks listOfExecutedTasks = ListOfExecutedTasks.getInstance();
        //When
        Task shoppingTask = taskFactory.createTask(TaskFactory.SHOPPINGTASK);
        shoppingTask.executeTask();
        //Then
        Assert.assertEquals(true, listOfExecutedTasks.getExecutedTasks().contains(shoppingTask.getTaskName()));
    }

    @Test
    public void testFactoryPaintingTask() {
        //Given
        TaskFactory taskFactory = new TaskFactory();
        ListOfExecutedTasks listOfExecutedTasks = ListOfExecutedTasks.getInstance();
        //When
        Task paintingTask = taskFactory.createTask(TaskFactory.PAINTINGTASK);
        paintingTask.executeTask();
        //Then
        Assert.assertEquals(true, listOfExecutedTasks.getExecutedTasks().contains(paintingTask.getTaskName()));
    }

    @Test
    public void testFactoryDrivingTask() {
        //Given
        TaskFactory taskFactory = new TaskFactory();
        ListOfExecutedTasks listOfExecutedTasks = ListOfExecutedTasks.getInstance();
        //When
        Task drivingTask = taskFactory.createTask(TaskFactory.DRIVINGTASK);
        drivingTask.executeTask();
        //Then
        Assert.assertEquals(true, listOfExecutedTasks.getExecutedTasks().contains(drivingTask.getTaskName()));
    }
}
