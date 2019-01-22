package com.kodilla.spring.portfolio;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

public class BoardTestSuite {
    @Test
    public void testTaskAdd() {
        //Given
        ApplicationContext context = new AnnotationConfigApplicationContext(BoardConfig.class);
        String toDoTask = "toDo";
        String inProgressTask = "inProgress";
        String doneTask = "done";
        TaskList getToDoList = (TaskList) context.getBean("toDoList");
        TaskList getInProgressList = (TaskList) context.getBean("inProgressList");
        TaskList getDoneList = (TaskList) context.getBean("doneList");
        //When
        getToDoList.getTasks().add(toDoTask);
        getInProgressList.getTasks().add(inProgressTask);
        getDoneList.getTasks().add(doneTask);
        String retrieveToDo = getToDoList.getTasks().get(0);
        String retrieveInProgress = getInProgressList.getTasks().get(0);
        String retrieveDone = getDoneList.getTasks().get(0);
        //Then
        System.out.println("Task from to do list: "+retrieveToDo);
        System.out.println("Task from in progress list: "+retrieveInProgress);
        System.out.println("Task from dine list: "+retrieveDone);
    }

    @Test
    public void testContext() {
        //Given
        ApplicationContext context =
                new AnnotationConfigApplicationContext("com.kodilla.spring.portfolio");

        //When & Then
        System.out.println("===== Beans list: ==== >>");
        Arrays.stream(context.getBeanDefinitionNames())
                .forEach(System.out::println);
        System.out.println("<< ===== Beans list ====");
    }
}
