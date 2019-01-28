package com.kodilla.patterns.factory.tasks;

public class ShoppingTask implements Task {
    private String taskName;
    private String whatToBuy;
    private double quantity;
    private boolean executed;

    public ShoppingTask(String taskName, String whatToBuy, double quantity) {
        this.taskName = taskName;
        this.whatToBuy = whatToBuy;
        this.quantity = quantity;
    }

    @Override
    public void executeTask() {
        System.out.println("Buying " + getWhatToBuy() + ", " + getQuantity() + ". ");
        executed = true;
        ListOfExecutedTasks listOfExecutedTasks = ListOfExecutedTasks.getInstance();
        listOfExecutedTasks.getExecutedTasks().add(getTaskName());
    }

    @Override
    public boolean isTaskExecuted() {
        return executed;
    }

    public String getTaskName() {
        return taskName;
    }

    public String getWhatToBuy() {
        return whatToBuy;
    }

    public double getQuantity() {
        return quantity;
    }
}
