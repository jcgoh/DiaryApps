package com.example.diaryapps.Item.HomePage;

import java.util.ArrayList;

public class MoodDateItem {
    private String Date;
    private ArrayList<MoodItem> MoodList = new ArrayList<>();

    public MoodDateItem(){} // Public constructor;

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public ArrayList<MoodItem> getMoodList() {
        return MoodList;
    }

    public void setMoodList(ArrayList<MoodItem> moodList) {
        MoodList = moodList;
    }
}
