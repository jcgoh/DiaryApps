package com.example.diaryapps.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.diaryapps.Fragment.DeleteGoalFragment;
import com.example.diaryapps.Item.GoalItem;
import com.example.diaryapps.R;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;


public class GoalAdapter extends RecyclerView.Adapter<GoalAdapter.ItemViewHolder>{
    public static GoalAdapter _instance;

    public String goalName;
    public String goalId;

    public List<GoalItem> arrayListItems = new ArrayList<>();
    public GoalAdapter(List<GoalItem> items){this.arrayListItems = items;}
    private Context context;

    private DeleteGoalFragment deleteGoalFragment;

    public static class ItemViewHolder extends RecyclerView.ViewHolder{

        private TextView mTvGoal;
        private CardView mCvGoal;

        ItemViewHolder(View itemView) {
            super(itemView);

            mTvGoal = itemView.findViewById(R.id.tvGoal);
            mCvGoal = itemView.findViewById(R.id.cvGoal);
        }
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_goal, parent,false);
        GoalAdapter.ItemViewHolder ivh = new GoalAdapter.ItemViewHolder(v);
        context = v.getContext();
        _instance = this;
        return ivh;
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int i) {
        final int position = i;

        holder.mTvGoal.setText(arrayListItems.get(position).getGoalTitle());
        holder.mCvGoal.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {

                goalName = arrayListItems.get(position).getGoalTitle();
                goalId = arrayListItems.get(position).getGoalId();
                showDeleteGoalFrag(view);
                return false;
            }
        });

    }

    @Override
    public int getItemCount() {
        return arrayListItems.size();
    }

    public void showDeleteGoalFrag(View view) {
        deleteGoalFragment = DeleteGoalFragment.newInstance();
        deleteGoalFragment.show(((AppCompatActivity)context).getSupportFragmentManager(), DeleteGoalFragment.TAG);
    }

    public void hideDeleteGoalFrag(){
        deleteGoalFragment.dismiss();
    }

}
