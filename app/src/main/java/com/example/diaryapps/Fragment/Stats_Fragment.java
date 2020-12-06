package com.example.diaryapps.Fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.anychart.AnyChart;
import com.anychart.AnyChartView;
import com.anychart.chart.common.dataentry.DataEntry;
import com.anychart.chart.common.dataentry.ValueDataEntry;
import com.anychart.charts.Pie;
import com.example.diaryapps.Item.IntegerItem;
import com.example.diaryapps.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.eazegraph.lib.charts.PieChart;
import org.eazegraph.lib.models.PieModel;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


public class Stats_Fragment extends Fragment implements View.OnClickListener {
    private DatabaseReference mDatabase;

    private String []monthArray = {"JAN 2020","FEB 2020","MAR 2020","APR 2020","MAY 2020","JUN 2020","JUL 2020","AUG 2020","SEP 2020","OCT 2020","NOV 2020","DEC 2020"};
    private TextView mTvMonth;
    private int spSelection = 0;
    private int currentMonth;

    private Button mBtnLeft;
    private Button mBtnRight;

    private Calendar calendar = Calendar.getInstance();

    private PieChart pieChart;
    private TextView mTvAwesomePerc, mTvHappyPerc, mTvNormalPerc, mTvSadPerc, mTvDisappointedPerc;
    private double totalMoodCount;


    String[] moods = {"Awesome","Happy","Normal","Sad","Disappointed"};
    int[] moodCount = {0,0,0,0,0};
    ArrayList<IntegerItem> moodCountList = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View xmlHolder = inflater.inflate(R.layout.fragment_stats, null);
        currentMonth = calendar.get(Calendar.MONTH);
        mDatabase = FirebaseDatabase.getInstance().getReference();
        pieChart = xmlHolder.findViewById(R.id.piechart);

        mTvMonth = xmlHolder.findViewById(R.id.tvMonth);

        mTvAwesomePerc = xmlHolder.findViewById(R.id.tvAwesome);
        mTvHappyPerc = xmlHolder.findViewById(R.id.tvHappy);
        mTvNormalPerc = xmlHolder.findViewById(R.id.tvNormal);
        mTvSadPerc = xmlHolder.findViewById(R.id.tvSad);
        mTvDisappointedPerc = xmlHolder.findViewById(R.id.tvDisappointed);

        mBtnLeft = xmlHolder.findViewById(R.id.btnLeft);
        mBtnRight = xmlHolder.findViewById(R.id.btnRight);

        mBtnLeft.setOnClickListener(this);
        mBtnRight.setOnClickListener(this);

        spSelection = currentMonth;
        mTvMonth.setText(monthArray[spSelection]);

        for (int i=0;i<moodCount.length;i++){
            IntegerItem tempItem = new IntegerItem();
            tempItem.setCount(0);
            moodCountList.add(tempItem);
        }

        validateSp();
        getPieData();

        return xmlHolder;
    }

    public void validateSp(){
        if (spSelection > 10){
            mBtnRight.setEnabled(false);
            mBtnRight.setBackground(getContext().getResources().getDrawable(R.drawable.ic_right_grey));
        }else if (spSelection < 1){
            mBtnLeft.setEnabled(false);
            mBtnLeft.setBackground(getContext().getResources().getDrawable(R.drawable.ic_left_grey ));
        }else{
            mBtnLeft.setEnabled(true);
            mBtnRight.setEnabled(true);
            mBtnRight.setBackground(getContext().getResources().getDrawable(R.drawable.ic_right_purple ));
            mBtnLeft.setBackground(getContext().getResources().getDrawable(R.drawable.ic_left_purple ));
        }
    }

    public void getPieData(){

        for (int i=0;i<moodCountList.size();i++){
            moodCountList.get(i).setCount(0);
        }
        totalMoodCount = 0;

        mDatabase.child("2020").child(Integer.toString(spSelection+1)).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot firstDSP: snapshot.getChildren()) {

                    String day = firstDSP.getKey();

                    for (DataSnapshot secondDSP: snapshot.child(day).getChildren()){

                        String id = secondDSP.getKey();
                        String tempMood = snapshot.child(day).child(id).child("mood").getValue().toString();

                        switch (tempMood){
                            case "Awesome":
                                moodCountList.get(0).setCount(moodCountList.get(0).getCount()+1);
                                totalMoodCount++;
                                break;
                            case "Happy":
                                moodCountList.get(1).setCount(moodCountList.get(1).getCount()+1);
                                totalMoodCount++;
                                break;
                            case "Normal":
                                moodCountList.get(2).setCount(moodCountList.get(2).getCount()+1);
                                totalMoodCount++;
                                break;
                            case "Sad":
                                moodCountList.get(3).setCount(moodCountList.get(3).getCount()+1);
                                totalMoodCount++;
                                break;
                            case "Disappointed":
                                moodCountList.get(4).setCount(moodCountList.get(4).getCount()+1);
                                totalMoodCount++;
                                break;
                        }
                    }
                }
                setData();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    private void setData()
    {
        pieChart.clearChart();

        if (moodCountList.get(0).getCount()==0 && moodCountList.get(1).getCount()==0 && moodCountList.get(2).getCount()==0 && moodCountList.get(3).getCount()==0 && moodCountList.get(4).getCount()==0){
            pieChart.addPieSlice(new PieModel("No Data",0, getContext().getResources().getColor(R.color.black_1000)));
        }else {
            // Set the data and color to the pie chart
            pieChart.addPieSlice(
                    new PieModel("Awesome", moodCountList.get(0).getCount(), getContext().getResources().getColor(R.color.green_500)));
            pieChart.addPieSlice(
                    new PieModel("Happy", moodCountList.get(1).getCount(), getContext().getResources().getColor(R.color.blue_500)));
            pieChart.addPieSlice(
                    new PieModel("Normal", moodCountList.get(2).getCount(), getContext().getResources().getColor(R.color.yellow_600)));
            pieChart.addPieSlice(
                    new PieModel("Sad", moodCountList.get(3).getCount(), getContext().getResources().getColor(R.color.orange_600)));
            pieChart.addPieSlice(
                    new PieModel("Disappointed", moodCountList.get(4).getCount(), getContext().getResources().getColor(R.color.red_600)));
        }
        // To animate the pie chart
        pieChart.startAnimation();

        if (totalMoodCount != 0) {
            mTvAwesomePerc.setText(String.format("%.2f %%", ((moodCountList.get(0).getCount()*100)/ totalMoodCount)));
            mTvHappyPerc.setText(String.format("%.2f %%", ((moodCountList.get(1).getCount()*100)/ totalMoodCount)));
            mTvNormalPerc.setText(String.format("%.2f %%", ((moodCountList.get(2).getCount()*100)/ totalMoodCount)));
            mTvSadPerc.setText(String.format("%.2f %%", ((moodCountList.get(3).getCount()*100)/ totalMoodCount)));
            mTvDisappointedPerc.setText(String.format("%.2f %%", ((moodCountList.get(4).getCount()*100)/ totalMoodCount)));
        }else{
            mTvAwesomePerc.setText("0 %");
            mTvHappyPerc.setText("0 %");
            mTvNormalPerc.setText("0 %");
            mTvSadPerc.setText("0 %");
            mTvDisappointedPerc.setText("0 %");
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnLeft:
                spSelection -= 1;
                mTvMonth.setText(monthArray[spSelection]);
                validateSp();
                getPieData();
                break;
            case R.id.btnRight:
                spSelection += 1;
                mTvMonth.setText(monthArray[spSelection]);
                validateSp();
                getPieData();
                break;
        }
    }
}
