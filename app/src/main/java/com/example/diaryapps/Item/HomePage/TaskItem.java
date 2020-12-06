package com.example.diaryapps.Item.HomePage;

public class TaskItem {
    private String Mood;
    private String Task;

    public TaskItem(){} //Public constructor

    public String getMood() {
        return Mood;
    }

    public void setMood(String mood) {
        Mood = mood;
    }

    public String getTask() {
        return Task;
    }

    public void setTask(String task) {
        Task = task;
    }
}
