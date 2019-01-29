package com.kodilla.patterns.factory.tasks;

public class DrivingTask implements Task {
    private String taskName;
    private String where;
    private String using;
    private boolean executed;

    public DrivingTask(String taskName, String where, String using) {
        this.taskName = taskName;
        this.where = where;
        this.using = using;
    }

    @Override
    public void executeTask() {
        System.out.println("Driving " + getWhere() + " with " + getUsing() + ". ");
        ListOfExecutedTasks listOfExecutedTasks = ListOfExecutedTasks.getInstance();
        listOfExecutedTasks.getExecutedTasks().add(getTaskName());
        executed = true;
    }

    @Override
    public boolean isTaskExecuted() {
        return executed;
    }

    public String getTaskName() {
        return taskName;
    }

    public String getWhere() {
        return where;
    }

    public String getUsing() {
        return using;
    }
}
