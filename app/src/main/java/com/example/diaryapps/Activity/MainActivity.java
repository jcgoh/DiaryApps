package com.example.diaryapps.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.example.diaryapps.Fragment.Calendar_Fragment;
import com.example.diaryapps.Fragment.DeleteGoalFragment;
import com.example.diaryapps.Fragment.Home_Fragment;
import com.example.diaryapps.Fragment.Stats_Fragment;
import com.example.diaryapps.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity implements DeleteGoalFragment.ItemClickListener {

    private FloatingActionButton fabAdd , fabAddMood , fabAddGoal;
    private boolean isFABOpen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fabAdd = findViewById(R.id.fbAdd);
        fabAddMood = findViewById(R.id.fbAddMood);
        fabAddGoal = findViewById(R.id.fbAddGoal);

        fabAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!isFABOpen){
                    showFABMenu();
                }else{
                    closeFABMenu();
                }
            }
        });

        fabAddMood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this,AddMoodActivity.class);
                startActivity(i);
            }
        });

        fabAddGoal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, AddGoalActivity.class);
                startActivity(i);
            }
        });


        Fragment fragment = new Home_Fragment();
        loadFragment(fragment);

        //Loading the bottom navigation bar into the app
        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomNav);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment = null;
                switch (item.getItemId()) {
                    case R.id.home:
                        fragment = new Home_Fragment();
                        break;
                    case R.id.calendar:
                        fragment = new Calendar_Fragment();
                        break;
                    case R.id.stats:
                        fragment = new Stats_Fragment();
                        break;
                }
                return loadFragment(fragment);
            }
        });
    }

    private boolean loadFragment(Fragment fragment) {
        //switching fragment
        if (fragment != null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.frameLayout, fragment)
                    .commit();
            return true;
        }
        return false;
    }

    private void showFABMenu(){
        isFABOpen=true;
        fabAddMood.animate().translationY(-getResources().getDimension(R.dimen.standard_55));
        fabAddGoal.animate().translationY(-getResources().getDimension(R.dimen.standard_105));
    }

    private void closeFABMenu(){
        isFABOpen=false;
        fabAddMood.animate().translationY(0);
        fabAddGoal.animate().translationY(0);
    }

    @Override
    public void onItemClick(String item) {

    }
}
