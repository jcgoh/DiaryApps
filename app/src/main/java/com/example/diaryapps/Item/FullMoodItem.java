package com.example.diaryapps.Item;

public class FullMoodItem {
    private String Mood;
    private String TaskList;
    private String DateString;
    private String Time;
    private String AdditionalNote;

    public FullMoodItem (){} //Public constructor

    public String getMood() {
        return Mood;
    }

    public void setMood(String mood) {
        Mood = mood;
    }

    public String getTaskList() {
        return TaskList;
    }

    public void setTaskList(String taskList) {
        TaskList = taskList;
    }

    public String getDateString() {
        return DateString;
    }

    public void setDateString(String dateString) {
        DateString = dateString;
    }

    public String getTime() {
        return Time;
    }

    public void setTime(String time) {
        Time = time;
    }

    public String getAdditionalNote() {
        return AdditionalNote;
    }

    public void setAdditionalNote(String additionalNote) {
        AdditionalNote = additionalNote;
    }
}
