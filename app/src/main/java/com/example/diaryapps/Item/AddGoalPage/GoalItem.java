package com.example.diaryapps.Item.AddGoalPage;

public class GoalItem {
    private String goalName;
    private boolean isClicked;

    public GoalItem(){} // Public constructor

    public String getGoalName() {
        return goalName;
    }

    public void setGoalName(String goalName) {
        this.goalName = goalName;
    }

    public boolean isClicked() {
        return isClicked;
    }

    public void setClicked(boolean clicked) {
        isClicked = clicked;
    }
}
