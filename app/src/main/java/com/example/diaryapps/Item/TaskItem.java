package com.example.diaryapps.Item;

public class TaskItem {
    private String taskName;
    private boolean isClicked;

    public TaskItem(){} // Public constructor

    public TaskItem(String taskName, boolean isClicked) {
        this.taskName = taskName;
        this.isClicked = isClicked;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public boolean isClicked() {
        return isClicked;
    }

    public void setClicked(boolean clicked) {
        isClicked = clicked;
    }
}
