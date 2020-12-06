package com.example.diaryapps.Activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.diaryapps.Adapter.AddGoalPage.AddGoalAdapter;
import com.example.diaryapps.Adapter.GoalAdapter;
import com.example.diaryapps.Item.AddGoalPage.GoalItem;
import com.example.diaryapps.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class AddGoalActivity extends AppCompatActivity implements View.OnClickListener {
    public static AddGoalActivity _instance;
    private DatabaseReference mDatabase;

    private RecyclerView mRvGoals;
    private AddGoalAdapter goalAdapter;
    private ArrayList<GoalItem> goalItemsArrayList = new ArrayList<>();

    private Button mBtnAdd;
    private boolean addStatus = true;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_goals);
        _instance = this;
        mDatabase = FirebaseDatabase.getInstance().getReference();

        mRvGoals = findViewById(R.id.rvGoals);
        goalAdapter = new AddGoalAdapter(goalItemsArrayList);
        mRvGoals.setAdapter(goalAdapter);
        mRvGoals.setLayoutManager(new LinearLayoutManager(AddGoalActivity.this));

        mBtnAdd = findViewById(R.id.btnAdd);
        mBtnAdd.setOnClickListener(this);

        initiateData();
    }

    public void initiateData(){
        GoalItem temp1 = new GoalItem();
        GoalItem temp2 = new GoalItem();
        GoalItem temp3 = new GoalItem();
        GoalItem temp4 = new GoalItem();
        GoalItem temp5 = new GoalItem();
        GoalItem temp6 = new GoalItem();
        GoalItem temp7 = new GoalItem();
        GoalItem temp8 = new GoalItem();

        temp1.setGoalName("Sleep Early");
        temp2.setGoalName("Eat Healthy");
        temp3.setGoalName("No Smoking");
        temp4.setGoalName("No Cellphone");
        temp5.setGoalName("No Internet");
        temp6.setGoalName("Music");
        temp7.setGoalName("Drawing");
        temp8.setGoalName("Exercise");

        goalItemsArrayList.add(temp1);
        goalItemsArrayList.add(temp2);
        goalItemsArrayList.add(temp3);
        goalItemsArrayList.add(temp4);
        goalItemsArrayList.add(temp5);
        goalItemsArrayList.add(temp6);
        goalItemsArrayList.add(temp7);
        goalItemsArrayList.add(temp8);

        goalAdapter.notifyDataSetChanged();
    }

    public void onClicked(int position){
        for (int i=0;i<goalItemsArrayList.size();i++) {
            if (i == position)
                goalItemsArrayList.get(i).setClicked(!goalItemsArrayList.get(i).isClicked());
            else
                goalItemsArrayList.get(i).setClicked(false);
        }
        goalAdapter.notifyDataSetChanged();
    }

    public void addGoal(final String goalToAdd){

        mDatabase.child("Goals").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot dsp : snapshot.getChildren()) {
                    String id = dsp.getKey();
                    String goals = snapshot.child(id).getValue().toString();

                    if (goals.equals(goalToAdd)) {
                        addStatus = false;
                        break;
                    }
                }

                if (addStatus)
                    mDatabase.child("Goals").push().setValue(goalToAdd);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnAdd:
                for (int i=0;i<goalItemsArrayList.size();i++){
                    if (goalItemsArrayList.get(i).isClicked())
                        addGoal(goalItemsArrayList.get(i).getGoalName());
                }
                _instance.finish();
            break;

        }
    }
}
