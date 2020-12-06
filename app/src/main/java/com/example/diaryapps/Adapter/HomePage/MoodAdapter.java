package com.example.diaryapps.Adapter.HomePage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.diaryapps.Item.HomePage.MoodItem;
import com.example.diaryapps.Item.HomePage.TaskItem;
import com.example.diaryapps.R;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


public class MoodAdapter extends RecyclerView.Adapter<MoodAdapter.ItemViewHolder>{

    public List<MoodItem> arrayListItems = new ArrayList<>();
    public MoodAdapter(List<MoodItem> items){this.arrayListItems = items;}

    private Context context;
    private TaskAdapter taskAdapter;
    private ArrayList<TaskItem> taskArrayList = new ArrayList<>();

    public static class ItemViewHolder extends RecyclerView.ViewHolder{

        private ImageView mIvEmote;
        private Button mBtnDropDown;
        private TextView mTvMood;
        private TextView mTvTime;
        private RecyclerView mRvTask;
        private TextView mTvAdditional;
        private View mViewGrey;


        ItemViewHolder(View itemView) {
            super(itemView);

            mIvEmote = itemView.findViewById(R.id.ivEmote);
            mBtnDropDown = itemView.findViewById(R.id.btnDropDown);
            mTvMood = itemView.findViewById(R.id.tvMood);
            mTvTime = itemView.findViewById(R.id.tvTime);
            mRvTask = itemView.findViewById(R.id.rvTask);
            mTvAdditional = itemView.findViewById(R.id.tvAdditional);
            mViewGrey = itemView.findViewById(R.id.viewGrey);
        }
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mood, parent,false);
        MoodAdapter.ItemViewHolder ivh = new MoodAdapter.ItemViewHolder(v);
        context = v.getContext();
        return ivh;
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int i) {
        int position = i;

        String mood = arrayListItems.get(position).getMood();
        holder.mTvMood.setText(mood);
        holder.mTvTime.setText(arrayListItems.get(position).getTime());
        if (arrayListItems.get(position).getAdditional().equals(""))
            holder.mTvAdditional.setVisibility(View.GONE);
        else
            holder.mTvAdditional.setText(arrayListItems.get(position).getAdditional());

        if (position == arrayListItems.size()-1){
            holder.mViewGrey.setVisibility(View.GONE);
        }

        switch (mood){
            case "Awesome":
                holder.mIvEmote.setImageDrawable(context.getDrawable(R.drawable.ic_awesome));
                holder.mTvMood.setTextColor(context.getResources().getColor(R.color.green_500));
                break;
            case "Happy":
                holder.mIvEmote.setImageDrawable(context.getDrawable(R.drawable.ic_happy));
                holder.mTvMood.setTextColor(context.getResources().getColor(R.color.blue_500));
                break;
            case "Normal":
                holder.mIvEmote.setImageDrawable(context.getDrawable(R.drawable.ic_normal));
                holder.mTvMood.setTextColor(context.getResources().getColor(R.color.yellow_600));
                break;
            case "Sad":
                holder.mIvEmote.setImageDrawable(context.getDrawable(R.drawable.ic_sad));
                holder.mTvMood.setTextColor(context.getResources().getColor(R.color.orange_600));
                break;
            case "Disappointed":
                holder.mIvEmote.setImageDrawable(context.getDrawable(R.drawable.ic_disappointed));
                holder.mTvMood.setTextColor(context.getResources().getColor(R.color.red_600));
                break;
        }

        taskArrayList = new ArrayList<TaskItem>();
        taskArrayList = arrayListItems.get(position).getTaskList();

        taskAdapter = new TaskAdapter(taskArrayList);
        holder.mRvTask.setLayoutManager(new GridLayoutManager(context,3));
        holder.mRvTask.setAdapter(taskAdapter);

    }

    @Override
    public int getItemCount() {
        return arrayListItems.size();
    }

}

