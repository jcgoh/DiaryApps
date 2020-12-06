package com.example.diaryapps.Fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.diaryapps.Adapter.GoalAdapter;
import com.example.diaryapps.R;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class DeleteGoalFragment extends BottomSheetDialogFragment {
    public static final String TAG = "ActionBottomDialog";
    private DatabaseReference mDatabase;

    private String goalId;
    private String goalName;

    private ItemClickListener mListener;

    private TextView mTvGoal;
    private Button mBtnDelete;

    public static DeleteGoalFragment newInstance() {
        return new DeleteGoalFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.delete_goal_dialog, container, false);
        mDatabase = FirebaseDatabase.getInstance().getReference();

        mBtnDelete = view.findViewById(R.id.btnDelete);

        mTvGoal = view.findViewById(R.id.tvGoal);
        mTvGoal.setText(GoalAdapter._instance.goalName);

        mBtnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    deleteGoal();
            }
        });



        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ;

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof ItemClickListener) {
            mListener = (ItemClickListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement ItemClickListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface ItemClickListener {
        void onItemClick(String item);
    }

    public void deleteGoal(){
        mDatabase.child("Goals").child(GoalAdapter._instance.goalId).removeValue();
        GoalAdapter._instance.hideDeleteGoalFrag();
    }
}
