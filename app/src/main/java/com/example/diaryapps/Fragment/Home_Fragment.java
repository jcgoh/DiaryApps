package com.example.diaryapps.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.diaryapps.Adapter.GoalAdapter;
import com.example.diaryapps.Adapter.HomePage.MoodDateAdapter;
import com.example.diaryapps.Item.GoalItem;
import com.example.diaryapps.Item.HomePage.MoodDateItem;
import com.example.diaryapps.Item.HomePage.MoodItem;
import com.example.diaryapps.Item.HomePage.TaskItem;
import com.example.diaryapps.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class Home_Fragment extends Fragment {
    private DatabaseReference mDatabase;

    private RecyclerView mRvMood;
    private MoodDateAdapter moodDateAdapter;
    private ArrayList<MoodDateItem> moodDateArrayList = new ArrayList<>();
    private ArrayList<MoodItem> moodItemArrayList = new ArrayList<>();
    private ArrayList<TaskItem> taskMoodArrayList = new ArrayList<>();

    String test = "";
    List<String> tempList = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View xmlHolder = inflater.inflate(R.layout.fragment_home, null);
        mDatabase = FirebaseDatabase.getInstance().getReference();

        mRvMood = xmlHolder.findViewById(R.id.rvMood);

        moodDateAdapter = new MoodDateAdapter(moodDateArrayList);
        mRvMood.setAdapter(moodDateAdapter);
        mRvMood.setLayoutManager(new LinearLayoutManager(getContext()));

        updateData();

        return xmlHolder;
    }

    public void updateData(){
        mDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                moodDateArrayList.clear();
                moodItemArrayList.clear();

                for (DataSnapshot firstDSP: dataSnapshot.child("2020").getChildren()){

                    String month = firstDSP.getKey();

                    for (DataSnapshot secondDSP: dataSnapshot.child("2020").child(month).getChildren()){

                        String day = secondDSP.getKey();
                        String dateString = "";
                        moodItemArrayList = new ArrayList<>();

                        for (DataSnapshot thirdDSP: dataSnapshot.child("2020").child(month).child(day).getChildren()){
                            String id = thirdDSP.getKey();

                            test = dataSnapshot.child("2020").child(month).child(day).child(id).child("taskList").getValue().toString();
                            tempList = new ArrayList<>();
                            tempList = Arrays.asList(test.split(","));

                            taskMoodArrayList = new ArrayList<>();

                            for (int i=0;i<tempList.size();i++) {
                                TaskItem tempTaskItem = new TaskItem();
                                tempTaskItem.setTask(tempList.get(i));
                                tempTaskItem.setMood(dataSnapshot.child("2020").child(month).child(day).child(id).child("mood").getValue().toString());
                                taskMoodArrayList.add(tempTaskItem);
                            }

                            MoodItem tempMoodItem = new MoodItem();
                            tempMoodItem.setTime(dataSnapshot.child("2020").child(month).child(day).child(id).child("time").getValue().toString());
                            tempMoodItem.setMood(dataSnapshot.child("2020").child(month).child(day).child(id).child("mood").getValue().toString());

                            if (dataSnapshot.child("2020").child(month).child(day).child(id).child("mood").getValue().toString().equals("")){
                                tempMoodItem.setAdditional("");
                            }else {
                                tempMoodItem.setAdditional(dataSnapshot.child("2020").child(month).child(day).child(id).child("additionalNote").getValue().toString());
                            }
                            tempMoodItem.setTaskList(taskMoodArrayList);
                            moodItemArrayList.add(tempMoodItem);

                            dateString = dataSnapshot.child("2020").child(month).child(day).child(id).child("dateString").getValue().toString();

                        }

                        MoodDateItem tempMoodDateItem = new MoodDateItem();
                        tempMoodDateItem.setDate(dateString);
                        tempMoodDateItem.setMoodList(moodItemArrayList);
                        moodDateArrayList.add(tempMoodDateItem);

                        moodDateAdapter.notifyDataSetChanged();
                    }
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

}
