package com.kodilla.patterns.factory.tasks;

public class TaskFactory {
    public static final String SHOPPINGTASK = "SHOPPING TASK";
    public static final String PAINTINGTASK = "PAINTING TASK";
    public static final String DRIVINGTASK = "DRIVING TASK";

    public final Task createTask(final String taskClass) {
        switch (taskClass) {
            case SHOPPINGTASK:
                return new ShoppingTask("Asda", "Rice", 30);
            case PAINTINGTASK:
                return new PaintingTask("Painting bedroom", "Blue", "Bedroom");
            case DRIVINGTASK:
                return new DrivingTask("Chicago", "Chicago", "Train");
            default:
                return null;
        }
    }
}
