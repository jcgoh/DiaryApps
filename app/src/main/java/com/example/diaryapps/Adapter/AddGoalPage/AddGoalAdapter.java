package com.example.diaryapps.Adapter.AddGoalPage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.diaryapps.Activity.AddGoalActivity;
import com.example.diaryapps.Adapter.HomePage.TaskAdapter;
import com.example.diaryapps.Item.AddGoalPage.GoalItem;
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


public class AddGoalAdapter extends RecyclerView.Adapter<AddGoalAdapter.ItemViewHolder> {

    public List<com.example.diaryapps.Item.AddGoalPage.GoalItem> arrayListItems = new ArrayList<>();

    public AddGoalAdapter(List<GoalItem> items) {
        this.arrayListItems = items;
    }

    private Context context;

    public static class ItemViewHolder extends RecyclerView.ViewHolder {

        private LinearLayout addGoalPanel;
        private RadioButton mRbGoal;
        private ImageView mIvGoal;
        private TextView mTvGoal;
        private View view;


        ItemViewHolder(View itemView) {
            super(itemView);

            addGoalPanel = itemView.findViewById(R.id.addGoalPanel);
            mRbGoal = itemView.findViewById(R.id.rbGoal);
            mIvGoal = itemView.findViewById(R.id.ivGoal);
            mTvGoal = itemView.findViewById(R.id.tvGoal);
            view = itemView.findViewById(R.id.view);
        }
    }

        @NonNull
        @Override
        public AddGoalAdapter.ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_add_goal, parent, false);
            AddGoalAdapter.ItemViewHolder ivh = new AddGoalAdapter.ItemViewHolder(v);
            context = v.getContext();
            return ivh;
        }

        @Override
        public void onBindViewHolder(@NonNull AddGoalAdapter.ItemViewHolder holder, int i) {
            final int position = i;

            holder.mTvGoal.setText(arrayListItems.get(position).getGoalName());

            switch (arrayListItems.get(position).getGoalName()){
                case "Sleep Early":
                    holder.mIvGoal.setImageDrawable(context.getDrawable(R.drawable.ic_sleep_early));
                    break;
                case "Eat Healthy":
                    holder.mIvGoal.setImageDrawable(context.getDrawable(R.drawable.ic_eat_healthy_purple));
                    break;
                case "No Smoking":
                    holder.mIvGoal.setImageDrawable(context.getDrawable(R.drawable.ic_no_smoking_purple));
                    break;
                case "No Cellphone":
                    holder.mIvGoal.setImageDrawable(context.getDrawable(R.drawable.ic_no_cellphone));
                    break;
                case "No Internet":
                    holder.mIvGoal.setImageDrawable(context.getDrawable(R.drawable.ic_no_internet));
                    break;
                case "Music":
                    holder.mIvGoal.setImageDrawable(context.getDrawable(R.drawable.ic_music));
                    break;
                case "Drawing":
                    holder.mIvGoal.setImageDrawable(context.getDrawable(R.drawable.ic_drawing));
                    break;
                case "Exercise":
                    holder.mIvGoal.setImageDrawable(context.getDrawable(R.drawable.ic_exercise_purple));
                    break;
            }

            if (arrayListItems.get(position).isClicked()){
                holder.mRbGoal.setChecked(true);
            }else{
                holder.mRbGoal.setChecked(false);
            }
            holder.addGoalPanel.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    AddGoalActivity._instance.onClicked(position);
                }
            });

        }

        @Override
        public int getItemCount() {
            return arrayListItems.size();
        }
}


