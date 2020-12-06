package com.example.diaryapps.Item;

public class GoalItem {
    private String additionalNote;
    private String goalTitle;
    private String goalId;
    private int goalStreak;
    private int goalLongestStreak;
    private double completionRate;
    private int totalCompletionDay;
    private boolean reminderEnabled;
    private String repeatValue ; // Everyday or every week etc.

    public GoalItem(){} // Public constructor

    public GoalItem(String additionalNote, String goalTitle, String goalId, int goalStreak, int goalLongestStreak, double completionRate, int totalCompletionDay, boolean reminderEnabled, String repeatValue) {
        this.additionalNote = additionalNote;
        this.goalTitle = goalTitle;
        this.goalId = goalId;
        this.goalStreak = goalStreak;
        this.goalLongestStreak = goalLongestStreak;
        this.completionRate = completionRate;
        this.totalCompletionDay = totalCompletionDay;
        this.reminderEnabled = reminderEnabled;
        this.repeatValue = repeatValue;
    }

    public String getAdditionalNote() {
        return additionalNote;
    }

    public void setAdditionalNote(String additionalNote) {
        this.additionalNote = additionalNote;
    }

    public String getGoalTitle() {
        return goalTitle;
    }

    public void setGoalTitle(String goalTitle) {
        this.goalTitle = goalTitle;
    }

    public String getGoalId() {
        return goalId;
    }

    public void setGoalId(String goalId) {
        this.goalId = goalId;
    }

    public int getGoalStreak() {
        return goalStreak;
    }

    public void setGoalStreak(int goalStreak) {
        this.goalStreak = goalStreak;
    }

    public int getGoalLongestStreak() {
        return goalLongestStreak;
    }

    public void setGoalLongestStreak(int goalLongestStreak) {
        this.goalLongestStreak = goalLongestStreak;
    }

    public double getCompletionRate() {
        return completionRate;
    }

    public void setCompletionRate(double completionRate) {
        this.completionRate = completionRate;
    }

    public int getTotalCompletionDay() {
        return totalCompletionDay;
    }

    public void setTotalCompletionDay(int totalCompletionDay) {
        this.totalCompletionDay = totalCompletionDay;
    }

    public boolean isReminderEnabled() {
        return reminderEnabled;
    }

    public void setReminderEnabled(boolean reminderEnabled) {
        this.reminderEnabled = reminderEnabled;
    }

    public String getRepeatValue() {
        return repeatValue;
    }

    public void setRepeatValue(String repeatValue) {
        this.repeatValue = repeatValue;
    }
}
