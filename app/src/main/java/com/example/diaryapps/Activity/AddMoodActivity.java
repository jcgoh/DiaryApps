package com.example.diaryapps.Activity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.diaryapps.Adapter.AddMoodPage.TaskAdapter;
import com.example.diaryapps.Item.FullMoodItem;
import com.example.diaryapps.Item.TaskItem;
import com.example.diaryapps.R;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.SimpleDateFormat;
import java.time.OffsetTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class AddMoodActivity extends AppCompatActivity implements View.OnClickListener {
    public static AddMoodActivity _instance;
    private DatabaseReference mDatabase;

    private ImageView mIvAwesome;
    private ImageView mIvHappy;
    private ImageView mIvNormal;
    private ImageView mIvSad;
    private ImageView mIvAngry;

    private ImageView mIvCheckAwesome;
    private ImageView mIvCheckHappy;
    private ImageView mIvCheckNormal;
    private ImageView mIvCheckSad;
    private ImageView mIvCheckAngry;

    private EditText mEtDate;
    private EditText mEtTime;
    private EditText mEtAdditional;

    private RecyclerView mRvTask;
    private TaskAdapter taskAdapter;
    private ArrayList<TaskItem> moodArrayList = new ArrayList<>();

    private TimePickerDialog picker;
    final Calendar myCalendar = Calendar.getInstance();
    private Button mBtnSave;
    private FullMoodItem fullMoodItem = new FullMoodItem();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_mood);
        _instance = this;
        mDatabase = FirebaseDatabase.getInstance().getReference();

        mBtnSave = findViewById(R.id.btnSave);
        mBtnSave.setOnClickListener(this);

        mIvAwesome = findViewById(R.id.ivAwesome);
        mIvHappy = findViewById(R.id.ivHappy);
        mIvNormal = findViewById(R.id.ivNormal);
        mIvSad = findViewById(R.id.ivSad);
        mIvAngry = findViewById(R.id.ivAngry);

        mIvAwesome.setOnClickListener(this);
        mIvHappy.setOnClickListener(this);
        mIvNormal.setOnClickListener(this);
        mIvSad.setOnClickListener(this);
        mIvAngry.setOnClickListener(this);

        mIvCheckAwesome = findViewById(R.id.ivCheckAwesome);
        mIvCheckHappy = findViewById(R.id.ivCheckHappy);
        mIvCheckNormal = findViewById(R.id.ivCheckNormal);
        mIvCheckSad = findViewById(R.id.ivCheckAnnoyed);
        mIvCheckAngry = findViewById(R.id.ivCheckAngry);

        mEtDate = findViewById(R.id.etDate);
        mEtTime = findViewById(R.id.etTime);
        mEtAdditional = findViewById(R.id.etAdditional);
        mRvTask = findViewById(R.id.rvTask);
        updateLabel();
        initiateData();


        final DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                // TODO Auto-generated method stub
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateLabel();
            }

        };

        mEtDate.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                new DatePickerDialog(AddMoodActivity.this, date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

        mEtTime.setInputType(InputType.TYPE_NULL);
        mEtTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar cldr = Calendar.getInstance();
                int hour = cldr.get(Calendar.HOUR_OF_DAY);
                int minutes = cldr.get(Calendar.MINUTE);
                // time picker dialog

                picker = new TimePickerDialog(AddMoodActivity.this,
                        new TimePickerDialog.OnTimeSetListener() {
                            @Override
                            public void onTimeSet(TimePicker tp, int sHour, int sMinute) {
                                mEtTime.setText(checkDigit(sHour) + ":" + checkDigit(sMinute));
                            }
                        }, hour, minutes, true);
                picker.show();
            }
        });

    }

    public String checkDigit(int number) {
        return number <= 9 ? "0" + number : String.valueOf(number);
    }

    private void updateLabel() {
        String myFormat = "MM/dd/yy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

        int day = myCalendar.get(Calendar.DAY_OF_WEEK);
        String Day = "NO DATA";

        switch (day){
            case Calendar.MONDAY:
                Day = "MONDAY";
                break;
            case Calendar.TUESDAY:
                Day = "TUESDAY";
                break;
            case Calendar.WEDNESDAY:
                Day = "WEDNESDAY";
                break;
            case Calendar.THURSDAY:
                Day = "THURSDAY";
                break;
            case Calendar.FRIDAY:
                Day = "FRIDAY";
                break;
            case Calendar.SATURDAY:
                Day = "SATURDAY";
                break;
            case Calendar.SUNDAY:
                Day = "SUNDAY";
                break;


        }
        OffsetTime offset = OffsetTime.now();
        mEtDate.setText(Day + ", " + sdf.format(myCalendar.getTime()));
        mEtTime.setText(checkDigit(offset.getHour()) +":" + checkDigit(offset.getMinute()));

        fullMoodItem.setDateString(mEtDate.getText().toString());
        fullMoodItem.setTime(mEtTime.getText().toString());
    }

    public void setClicked(int position){
        moodArrayList.get(position).setClicked(!moodArrayList.get(position).isClicked());
        taskAdapter.notifyDataSetChanged();
    }

    private void initiateData(){
        TaskItem task1 = new TaskItem();
        TaskItem task2 = new TaskItem();
        TaskItem task3 = new TaskItem();
        TaskItem task4 = new TaskItem();
        TaskItem task5 = new TaskItem();
        TaskItem task6 = new TaskItem();
        TaskItem task7 = new TaskItem();
        TaskItem task8 = new TaskItem();
        TaskItem task9 = new TaskItem();
        TaskItem task10 = new TaskItem();
        TaskItem task11 = new TaskItem();
        TaskItem task12 = new TaskItem();

        task1.setTaskName("Gaming");
        task2.setTaskName("Family");
        task3.setTaskName("Friends");
        task4.setTaskName("Date");
        task5.setTaskName("Sports");
        task6.setTaskName("Sleep");
        task7.setTaskName("Relax");
        task8.setTaskName("Shopping");
        task9.setTaskName("Reading");
        task10.setTaskName("Movie");
        task11.setTaskName("Vacation");
        task12.setTaskName("Park");


        moodArrayList.add(task1);
        moodArrayList.add(task2);
        moodArrayList.add(task3);
        moodArrayList.add(task4);
        moodArrayList.add(task5);
        moodArrayList.add(task6);
        moodArrayList.add(task7);
        moodArrayList.add(task8);
        moodArrayList.add(task9);
        moodArrayList.add(task10);
        moodArrayList.add(task11);
        moodArrayList.add(task12);

        taskAdapter = new TaskAdapter(moodArrayList);
        mRvTask.setAdapter(taskAdapter);
        mRvTask.setLayoutManager(new GridLayoutManager(AddMoodActivity.this,5));
    }

    private void saveData(){
        String year = Integer.toString(myCalendar.get(Calendar.YEAR));
        String month = Integer.toString(myCalendar.get(Calendar.MONTH) + 1);
        String date = Integer.toString(myCalendar.get(Calendar.DAY_OF_MONTH));

        for (int i=0;i<moodArrayList.size();i++){
            if(moodArrayList.get(i).isClicked()){
                if (fullMoodItem.getTaskList() != null)
                    fullMoodItem.setTaskList(fullMoodItem.getTaskList() + moodArrayList.get(i).getTaskName() + ",");
                else
                    fullMoodItem.setTaskList(moodArrayList.get(i).getTaskName() + ",");
            }
        }
        fullMoodItem.setAdditionalNote(mEtAdditional.getText().toString());
        fullMoodItem.setTime(mEtTime.getText().toString());

        mDatabase.child(year).child(month).child(date).push().setValue(fullMoodItem);
        _instance.finish();
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.ivAwesome:
                mIvCheckAwesome.setVisibility(View.VISIBLE);
                mIvCheckHappy.setVisibility(View.GONE);
                mIvCheckNormal.setVisibility(View.GONE);
                mIvCheckSad.setVisibility(View.GONE);
                mIvCheckAngry.setVisibility(View.GONE);
                fullMoodItem.setMood("Awesome");
                break;
            case R.id.ivHappy:
                mIvCheckAwesome.setVisibility(View.GONE);
                mIvCheckHappy.setVisibility(View.VISIBLE);
                mIvCheckNormal.setVisibility(View.GONE);
                mIvCheckSad.setVisibility(View.GONE);
                mIvCheckAngry.setVisibility(View.GONE);
                fullMoodItem.setMood("Happy");
                break;
            case R.id.ivNormal:
                mIvCheckAwesome.setVisibility(View.GONE);
                mIvCheckHappy.setVisibility(View.GONE);
                mIvCheckNormal.setVisibility(View.VISIBLE);
                mIvCheckSad.setVisibility(View.GONE);
                mIvCheckAngry.setVisibility(View.GONE);
                fullMoodItem.setMood("Normal");
                break;
            case R.id.ivSad:
                mIvCheckAwesome.setVisibility(View.GONE);
                mIvCheckHappy.setVisibility(View.GONE);
                mIvCheckNormal.setVisibility(View.GONE);
                mIvCheckSad.setVisibility(View.VISIBLE);
                mIvCheckAngry.setVisibility(View.GONE);
                fullMoodItem.setMood("Sad");
                break;
            case R.id.ivAngry:
                mIvCheckAwesome.setVisibility(View.GONE);
                mIvCheckHappy.setVisibility(View.GONE);
                mIvCheckNormal.setVisibility(View.GONE);
                mIvCheckSad.setVisibility(View.GONE);
                mIvCheckAngry.setVisibility(View.VISIBLE);
                fullMoodItem.setMood("Disappointed");
                break;
            case R.id.btnSave:
                saveData();
                break;
        }
    }
}
