package com.example.diaryapps.Item.HomePage;

import java.util.ArrayList;

public class MoodItem {
    private String Time;
    private String Mood;
    private String Additional;
    private ArrayList<TaskItem> TaskList = new ArrayList<>();

    public MoodItem(){} // Public constructor

    public String getTime() {
        return Time;
    }

    public void setTime(String time) {
        Time = time;
    }

    public String getMood() {
        return Mood;
    }

    public void setMood(String mood) {
        Mood = mood;
    }

    public ArrayList<TaskItem> getTaskList() {
        return TaskList;
    }

    public void setTaskList(ArrayList<TaskItem> taskList) {
        TaskList = taskList;
    }

    public String getAdditional() {
        return Additional;
    }

    public void setAdditional(String additional) {
        Additional = additional;
    }
}
