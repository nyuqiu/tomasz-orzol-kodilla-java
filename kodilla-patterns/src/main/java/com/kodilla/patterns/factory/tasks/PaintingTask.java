package com.kodilla.patterns.factory.tasks;

public class PaintingTask implements Task {
    private String taskName;
    private String color;
    private String whatToPaint;
    private boolean executed;

    public PaintingTask(String taskName, String color, String whatToPaint) {
        this.taskName = taskName;
        this.color = color;
        this.whatToPaint = whatToPaint;
    }

    @Override
    public void executeTask() {
        System.out.println("Coloring " + getWhatToPaint() + " with " + getColor() + ". ");
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

    public String getColor() {
        return color;
    }

    public String getWhatToPaint() {
        return whatToPaint;
    }
}
