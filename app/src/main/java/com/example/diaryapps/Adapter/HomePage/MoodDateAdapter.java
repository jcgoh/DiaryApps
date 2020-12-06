package com.example.diaryapps.Adapter.HomePage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.diaryapps.Item.HomePage.MoodDateItem;
import com.example.diaryapps.Item.HomePage.MoodItem;
import com.example.diaryapps.R;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


public class MoodDateAdapter extends RecyclerView.Adapter<MoodDateAdapter.ItemViewHolder>{

    public List<MoodDateItem> arrayListItems = new ArrayList<>();
    public MoodDateAdapter(List<MoodDateItem> items){this.arrayListItems = items;}

    private Context context;
    private MoodAdapter moodAdapter;
    private ArrayList<MoodItem> moodArrayList = new ArrayList<>();

    public static class ItemViewHolder extends RecyclerView.ViewHolder{

        private TextView mTvDate;
        private RecyclerView mRvMood;


        ItemViewHolder(View itemView) {
            super(itemView);

            mTvDate = itemView.findViewById(R.id.tvDate);
            mRvMood = itemView.findViewById(R.id.rvMood);
        }
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mood_date, parent,false);
        MoodDateAdapter.ItemViewHolder ivh = new MoodDateAdapter.ItemViewHolder(v);
        context = v.getContext();
        return ivh;
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int i) {
        int position = i;

        holder.mTvDate.setText(arrayListItems.get(position).getDate());

        moodArrayList = new ArrayList<>();
        moodArrayList = arrayListItems.get(position).getMoodList();

        moodAdapter = new MoodAdapter(moodArrayList);
        holder.mRvMood.setLayoutManager(new LinearLayoutManager(context));
        holder.mRvMood.setAdapter(moodAdapter);

    }

    @Override
    public int getItemCount() {
        return arrayListItems.size();
    }

}

