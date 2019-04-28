package com.kodilla.patterns2.observer.homework;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MentorTestSuite {
    @Test
    public void testUpdate() {
        //Given
        TaskQueue johnSmithTaskQueue = new JohnSmithTaskQueue();
        TaskQueue leeMillTaskQueue = new LeeMillTaskQueue();
        Mentor bobCage = new Mentor("Bob Cage");
        Mentor craigMad = new Mentor("Craig Mad");
        Mentor walterWhite = new Mentor("Walter White");
        johnSmithTaskQueue.registerObserver(bobCage);
        leeMillTaskQueue.registerObserver(craigMad);
        johnSmithTaskQueue.registerObserver(walterWhite);
        leeMillTaskQueue.registerObserver(walterWhite);
        //When
        johnSmithTaskQueue.addTask("task-22-4");
        johnSmithTaskQueue.addTask("task-12-2");
        leeMillTaskQueue.addTask("task-25-3");
        johnSmithTaskQueue.addTask("task-11-1");
        leeMillTaskQueue.addTask("task-23-5");
        //Then
        assertEquals(3, bobCage.getUpdateCount());
        assertEquals(2, craigMad.getUpdateCount());
        assertEquals(5, walterWhite.getUpdateCount());
    }

}