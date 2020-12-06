package com.example.diaryapps.Fragment;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.diaryapps.Adapter.GoalAdapter;
import com.example.diaryapps.Item.GoalItem;
import com.example.diaryapps.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class Calendar_Fragment extends Fragment {
    private DatabaseReference mDatabase;

    private RecyclerView mRvGoals;
    private GoalAdapter mGoalAdapter;
    private ArrayList<GoalItem> goalItemArrayList = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View xmlHolder = inflater.inflate(R.layout.fragment_calendar, null);
        mDatabase = FirebaseDatabase.getInstance().getReference();

        mRvGoals = xmlHolder.findViewById(R.id.rvGoals);

        mGoalAdapter = new GoalAdapter(goalItemArrayList);
        mRvGoals.setLayoutManager(new LinearLayoutManager(getContext()));
        mRvGoals.setAdapter(mGoalAdapter);


        getGoals();
        return xmlHolder;
    }

    public void getGoals(){
        mDatabase.child("Goals").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                goalItemArrayList.clear();

                for(DataSnapshot dsp : snapshot.getChildren()) {
                    String id = dsp.getKey();
                    String goals = snapshot.child(id).getValue().toString();

                    GoalItem tempItem = new GoalItem();
                    tempItem.setGoalTitle(goals);
                    tempItem.setGoalId(id);
                    goalItemArrayList.add(tempItem);
                    mGoalAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}
