package com.example.diaryapps.Adapter.HomePage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.diaryapps.Item.HomePage.TaskItem;
import com.example.diaryapps.R;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.ItemViewHolder>{

    public List<TaskItem> arrayListItems = new ArrayList<>();
    public TaskAdapter(List<TaskItem> items){this.arrayListItems = items;}
    private Context context;

    public static class ItemViewHolder extends RecyclerView.ViewHolder{

        private ImageView mIvFirstTask;
        private ImageView mIvSecondTask;
        private ImageView mIvThirdTask;
        private TextView mTvFirstTaskName;
        private TextView mTvSecondTaskName;
        private TextView mTvThirdTaskName;


        ItemViewHolder(View itemView) {
            super(itemView);

            mIvFirstTask = itemView.findViewById(R.id.ivFirstTask);
//            mIvSecondTask = itemView.findViewById(R.id.ivSecondTask);
//            mIvThirdTask = itemView.findViewById(R.id.ivThirdTask);
            mTvFirstTaskName = itemView.findViewById(R.id.tvFirstTaskName);
//            mTvSecondTaskName = itemView.findViewById(R.id.tvSecondTaskName);
//            mTvThirdTaskName = itemView.findViewById(R.id.tvThirdTaskName);
        }
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_task, parent,false);
        TaskAdapter.ItemViewHolder ivh = new TaskAdapter.ItemViewHolder(v);
        context = v.getContext();
        return ivh;
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int i) {
        int position = i;

        holder.mTvFirstTaskName.setText(arrayListItems.get(position).getTask());

        switch (arrayListItems.get(position).getTask()){
            case "Gaming":
                switch (arrayListItems.get(position).getMood()){
                    case "Awesome":
                        holder.mIvFirstTask.setImageDrawable(context.getDrawable(R.drawable.ic_gaming_green));
                        break;
                    case "Happy":
                        holder.mIvFirstTask.setImageDrawable(context.getDrawable(R.drawable.ic_gaming_blue));
                        break;
                    case "Normal":
                        holder.mIvFirstTask.setImageDrawable(context.getDrawable(R.drawable.ic_gaming_yellow));
                        break;
                    case "Sad":
                        holder.mIvFirstTask.setImageDrawable(context.getDrawable(R.drawable.ic_gaming_orange));
                        break;
                    case "Disappointed":
                        holder.mIvFirstTask.setImageDrawable(context.getDrawable(R.drawable.ic_gaming_red));
                        break;
                }
                break;
            case "Family":
                switch (arrayListItems.get(position).getMood()){
                    case "Awesome":
                        holder.mIvFirstTask.setImageDrawable(context.getDrawable(R.drawable.ic_family_green));
                        break;
                    case "Happy":
                        holder.mIvFirstTask.setImageDrawable(context.getDrawable(R.drawable.ic_family_blue));
                        break;
                    case "Normal":
                        holder.mIvFirstTask.setImageDrawable(context.getDrawable(R.drawable.ic_family_yellow));
                        break;
                    case "Sad":
                        holder.mIvFirstTask.setImageDrawable(context.getDrawable(R.drawable.ic_family_orange));
                        break;
                    case "Disappointed":
                        holder.mIvFirstTask.setImageDrawable(context.getDrawable(R.drawable.ic_family_red));
                        break;
                }
                break;
            case "Friends":
                switch (arrayListItems.get(position).getMood()){
                    case "Awesome":
                        holder.mIvFirstTask.setImageDrawable(context.getDrawable(R.drawable.ic_friends_green));
                        break;
                    case "Happy":
                        holder.mIvFirstTask.setImageDrawable(context.getDrawable(R.drawable.ic_friends_blue));
                        break;
                    case "Normal":
                        holder.mIvFirstTask.setImageDrawable(context.getDrawable(R.drawable.ic_friends_yellow));
                        break;
                    case "Sad":
                        holder.mIvFirstTask.setImageDrawable(context.getDrawable(R.drawable.ic_friends_orange));
                        break;
                    case "Disappointed":
                        holder.mIvFirstTask.setImageDrawable(context.getDrawable(R.drawable.ic_friends_red));
                        break;
                }
                break;
            case "Date":
                switch (arrayListItems.get(position).getMood()){
                    case "Awesome":
                        holder.mIvFirstTask.setImageDrawable(context.getDrawable(R.drawable.ic_date_green));
                        break;
                    case "Happy":
                        holder.mIvFirstTask.setImageDrawable(context.getDrawable(R.drawable.ic_date_blue));
                        break;
                    case "Normal":
                        holder.mIvFirstTask.setImageDrawable(context.getDrawable(R.drawable.ic_date_yellow));
                        break;
                    case "Sad":
                        holder.mIvFirstTask.setImageDrawable(context.getDrawable(R.drawable.ic_date_orange));
                        break;
                    case "Disappointed":
                        holder.mIvFirstTask.setImageDrawable(context.getDrawable(R.drawable.ic_date_red));
                        break;
                }
                break;
            case "Sports":
                switch (arrayListItems.get(position).getMood()){
                    case "Awesome":
                        holder.mIvFirstTask.setImageDrawable(context.getDrawable(R.drawable.ic_sports_green));
                        break;
                    case "Happy":
                        holder.mIvFirstTask.setImageDrawable(context.getDrawable(R.drawable.ic_sports_blue));
                        break;
                    case "Normal":
                        holder.mIvFirstTask.setImageDrawable(context.getDrawable(R.drawable.ic_sports_yellow));
                        break;
                    case "Sad":
                        holder.mIvFirstTask.setImageDrawable(context.getDrawable(R.drawable.ic_sports_orange));
                        break;
                    case "Disappointed":
                        holder.mIvFirstTask.setImageDrawable(context.getDrawable(R.drawable.ic_sports_red));
                        break;
                }
                break;
            case "Sleep":
                switch (arrayListItems.get(position).getMood()){
                    case "Awesome":
                        holder.mIvFirstTask.setImageDrawable(context.getDrawable(R.drawable.ic_sleep_green));
                        break;
                    case "Happy":
                        holder.mIvFirstTask.setImageDrawable(context.getDrawable(R.drawable.ic_sleep_blue));
                        break;
                    case "Normal":
                        holder.mIvFirstTask.setImageDrawable(context.getDrawable(R.drawable.ic_sleep_yellow));
                        break;
                    case "Sad":
                        holder.mIvFirstTask.setImageDrawable(context.getDrawable(R.drawable.ic_sleep_orange));
                        break;
                    case "Disappointed":
                        holder.mIvFirstTask.setImageDrawable(context.getDrawable(R.drawable.ic_sleep_red));
                        break;
                }
                break;
            case "Relax":
                switch (arrayListItems.get(position).getMood()){
                    case "Awesome":
                        holder.mIvFirstTask.setImageDrawable(context.getDrawable(R.drawable.ic_relax_green));
                        break;
                    case "Happy":
                        holder.mIvFirstTask.setImageDrawable(context.getDrawable(R.drawable.ic_relax_blue));
                        break;
                    case "Normal":
                        holder.mIvFirstTask.setImageDrawable(context.getDrawable(R.drawable.ic_relax_yellow));
                        break;
                    case "Sad":
                        holder.mIvFirstTask.setImageDrawable(context.getDrawable(R.drawable.ic_relax_orange));
                        break;
                    case "Disappointed":
                        holder.mIvFirstTask.setImageDrawable(context.getDrawable(R.drawable.ic_relax_red));
                        break;
                }
                break;
            case "Shopping":
                switch (arrayListItems.get(position).getMood()){
                    case "Awesome":
                        holder.mIvFirstTask.setImageDrawable(context.getDrawable(R.drawable.ic_shopping_green));
                        break;
                    case "Happy":
                        holder.mIvFirstTask.setImageDrawable(context.getDrawable(R.drawable.ic_shopping_blue));
                        break;
                    case "Normal":
                        holder.mIvFirstTask.setImageDrawable(context.getDrawable(R.drawable.ic_shopping_yellow));
                        break;
                    case "Sad":
                        holder.mIvFirstTask.setImageDrawable(context.getDrawable(R.drawable.ic_shopping_orange));
                        break;
                    case "Disappointed":
                        holder.mIvFirstTask.setImageDrawable(context.getDrawable(R.drawable.ic_shopping_red));
                        break;
                }
                break;
            case "Reading":
                switch (arrayListItems.get(position).getMood()){
                    case "Awesome":
                        holder.mIvFirstTask.setImageDrawable(context.getDrawable(R.drawable.ic_reading_green));
                        break;
                    case "Happy":
                        holder.mIvFirstTask.setImageDrawable(context.getDrawable(R.drawable.ic_reading_blue));
                        break;
                    case "Normal":
                        holder.mIvFirstTask.setImageDrawable(context.getDrawable(R.drawable.ic_reading_yellow));
                        break;
                    case "Sad":
                        holder.mIvFirstTask.setImageDrawable(context.getDrawable(R.drawable.ic_reading_orange));
                        break;
                    case "Disappointed":
                        holder.mIvFirstTask.setImageDrawable(context.getDrawable(R.drawable.ic_reading_red));
                        break;
                }
                break;
            case "Movie":
                switch (arrayListItems.get(position).getMood()){
                    case "Awesome":
                        holder.mIvFirstTask.setImageDrawable(context.getDrawable(R.drawable.ic_movies_green));
                        break;
                    case "Happy":
                        holder.mIvFirstTask.setImageDrawable(context.getDrawable(R.drawable.ic_mobies_blue));
                        break;
                    case "Normal":
                        holder.mIvFirstTask.setImageDrawable(context.getDrawable(R.drawable.ic_movies_yellow));
                        break;
                    case "Sad":
                        holder.mIvFirstTask.setImageDrawable(context.getDrawable(R.drawable.ic_movies_orange));
                        break;
                    case "Disappointed":
                        holder.mIvFirstTask.setImageDrawable(context.getDrawable(R.drawable.ic_movies_red));
                        break;
                }
                break;
            case "Vacation":
                switch (arrayListItems.get(position).getMood()){
                    case "Awesome":
                        holder.mIvFirstTask.setImageDrawable(context.getDrawable(R.drawable.ic_vacation_green));
                        break;
                    case "Happy":
                        holder.mIvFirstTask.setImageDrawable(context.getDrawable(R.drawable.ic_vacation_blue));
                        break;
                    case "Normal":
                        holder.mIvFirstTask.setImageDrawable(context.getDrawable(R.drawable.ic_vacation_yellow));
                        break;
                    case "Sad":
                        holder.mIvFirstTask.setImageDrawable(context.getDrawable(R.drawable.ic_vacation_orange));
                        break;
                    case "Disappointed":
                        holder.mIvFirstTask.setImageDrawable(context.getDrawable(R.drawable.ic_vacation_red));
                        break;
                }
                break;
            case "Park":
                switch (arrayListItems.get(position).getMood()){
                    case "Awesome":
                        holder.mIvFirstTask.setImageDrawable(context.getDrawable(R.drawable.ic_park_green));
                        break;
                    case "Happy":
                        holder.mIvFirstTask.setImageDrawable(context.getDrawable(R.drawable.ic_park_blue));
                        break;
                    case "Normal":
                        holder.mIvFirstTask.setImageDrawable(context.getDrawable(R.drawable.ic_park_yellow));
                        break;
                    case "Sad":
                        holder.mIvFirstTask.setImageDrawable(context.getDrawable(R.drawable.ic_park_orange));
                        break;
                    case "Disappointed":
                        holder.mIvFirstTask.setImageDrawable(context.getDrawable(R.drawable.ic_park_red));
                        break;
                }
                break;
        }


    }

    @Override
    public int getItemCount() {
        return arrayListItems.size();
    }

}
