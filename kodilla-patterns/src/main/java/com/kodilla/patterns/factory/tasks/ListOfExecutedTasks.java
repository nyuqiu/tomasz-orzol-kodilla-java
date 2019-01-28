package com.kodilla.patterns.factory.tasks;

import java.util.ArrayList;
import java.util.List;

public final class ListOfExecutedTasks {
    private static ListOfExecutedTasks listOfExecutedTasksInstance = null;
    static List<String> executedTasks = new ArrayList<>();

    private ListOfExecutedTasks() {
    }

    public static ListOfExecutedTasks getInstance() {
        if (listOfExecutedTasksInstance == null) {
            synchronized (executedTasks) {
                if (listOfExecutedTasksInstance == null) {
                    listOfExecutedTasksInstance = new ListOfExecutedTasks();
                }
            }
        }
        return listOfExecutedTasksInstance;
    }

    public static List<String> getExecutedTasks() {
        return executedTasks;
    }
}


