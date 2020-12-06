package com.example.diaryapps.Adapter.AddMoodPage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.diaryapps.Activity.AddMoodActivity;
import com.example.diaryapps.Item.GoalItem;
import com.example.diaryapps.Item.TaskItem;
import com.example.diaryapps.R;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;


public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.ItemViewHolder>{

    public List<TaskItem> arrayListItems = new ArrayList<>();
    public TaskAdapter(List<TaskItem> items){this.arrayListItems = items;}
    private Context context;

    public static class ItemViewHolder extends RecyclerView.ViewHolder{

        private ImageView mIvTask;
        private TextView mTvTaskName;
        private LinearLayout mTaskPanel, backgroundLayout;
        private RelativeLayout shapeLayout;
        private CardView mCvTask;

        ItemViewHolder(View itemView) {
            super(itemView);

            mIvTask = itemView.findViewById(R.id.ivTask);
            mTvTaskName = itemView.findViewById(R.id.tvTaskName);
            mTaskPanel = itemView.findViewById(R.id.taskPanel);
            shapeLayout = itemView.findViewById(R.id.shape_layout);
            mCvTask = itemView.findViewById(R.id.myCardView);
            backgroundLayout = itemView.findViewById(R.id.backgroundLayout);
        }
    }

    @NonNull
    @Override
    public TaskAdapter.ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_add_task, parent,false);
        TaskAdapter.ItemViewHolder ivh = new TaskAdapter.ItemViewHolder(v);
        context = v.getContext();
        return ivh;
    }

    @Override
    public void onBindViewHolder(@NonNull TaskAdapter.ItemViewHolder holder, int i) {
        final int position = i;

        holder.mTvTaskName.setText(arrayListItems.get(position).getTaskName());
        holder.mTaskPanel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AddMoodActivity._instance.setClicked(position);
            }
        });

        if(arrayListItems.get(position).isClicked()){
            holder.backgroundLayout.setBackground(context.getResources().getDrawable(R.drawable.circular_border_purple));

            switch (arrayListItems.get(position).getTaskName()){
                case "Gaming" :
                    holder.mIvTask.setImageDrawable(context.getDrawable(R.drawable.ic_gaming_white));
                    break;
                case "Family" :
                    holder.mIvTask.setImageDrawable(context.getDrawable(R.drawable.ic_family_white));
                    break;
                case "Friends" :
                    holder.mIvTask.setImageDrawable(context.getDrawable(R.drawable.ic_friends_white));
                    break;
                case "Date" :
                    holder.mIvTask.setImageDrawable(context.getDrawable(R.drawable.ic_date_white));
                    break;
                case "Sports" :
                    holder.mIvTask.setImageDrawable(context.getDrawable(R.drawable.ic_sports_white));
                    break;
                case "Sleep" :
                    holder.mIvTask.setImageDrawable(context.getDrawable(R.drawable.ic_sleep_white));
                    break;
                case "Relax" :
                    holder.mIvTask.setImageDrawable(context.getDrawable(R.drawable.ic_relax_white));
                    break;
                case "Shopping" :
                    holder.mIvTask.setImageDrawable(context.getDrawable(R.drawable.ic_shopping_white));
                    break;
                case "Reading" :
                    holder.mIvTask.setImageDrawable(context.getDrawable(R.drawable.ic_reading_white));
                    break;
                case "Movie" :
                    holder.mIvTask.setImageDrawable(context.getDrawable(R.drawable.ic_movies_white));
                    break;
                case "Vacation" :
                    holder.mIvTask.setImageDrawable(context.getDrawable(R.drawable.ic_vacation_white));
                    break;
                case "Park" :
                    holder.mIvTask.setImageDrawable(context.getDrawable(R.drawable.ic_park_white));
                    break;
            }
        }else {
            holder.backgroundLayout.setBackground(context.getResources().getDrawable(R.drawable.circular_border));
            switch (arrayListItems.get(position).getTaskName()) {
                case "Gaming":
                    holder.mIvTask.setImageDrawable(context.getDrawable(R.drawable.ic_game_purple));
                    break;
                case "Family":
                    holder.mIvTask.setImageDrawable(context.getDrawable(R.drawable.ic_family_purple));
                    break;
                case "Friends":
                    holder.mIvTask.setImageDrawable(context.getDrawable(R.drawable.ic_friends_purple));
                    break;
                case "Date":
                    holder.mIvTask.setImageDrawable(context.getDrawable(R.drawable.ic_date_purple));
                    break;
                case "Sports":
                    holder.mIvTask.setImageDrawable(context.getDrawable(R.drawable.ic_sports_purple));
                    break;
                case "Sleep":
                    holder.mIvTask.setImageDrawable(context.getDrawable(R.drawable.ic_sleep_purple));
                    break;
                case "Relax":
                    holder.mIvTask.setImageDrawable(context.getDrawable(R.drawable.ic_relax_purple));
                    break;
                case "Shopping":
                    holder.mIvTask.setImageDrawable(context.getDrawable(R.drawable.ic_shopping_purple));
                    break;
                case "Reading":
                    holder.mIvTask.setImageDrawable(context.getDrawable(R.drawable.ic_reading_purple));
                    break;
                case "Movie":
                    holder.mIvTask.setImageDrawable(context.getDrawable(R.drawable.ic_movies_purple));
                    break;
                case "Vacation":
                    holder.mIvTask.setImageDrawable(context.getDrawable(R.drawable.ic_vacation_purple));
                    break;
                case "Park":
                    holder.mIvTask.setImageDrawable(context.getDrawable(R.drawable.ic_park_purple));
                    break;
            }
        }

    }

    @Override
    public int getItemCount() {
        return arrayListItems.size();
    }

}

