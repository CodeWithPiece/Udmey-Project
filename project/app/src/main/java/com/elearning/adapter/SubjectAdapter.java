package com.elearning.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.elearning.R;
import com.elearning.model.SubjectModel;
import com.elearning.views.activity.SubjectActivity;
import com.google.android.material.checkbox.MaterialCheckBox;

import java.util.List;

public class SubjectAdapter extends RecyclerView.Adapter<SubjectAdapter.ViewHolder> {

    SubjectActivity subjectActivity;
    List<SubjectModel> subjectModelList;

    public SubjectAdapter(SubjectActivity subjectActivity, List<SubjectModel> subjectModelList) {
        this.subjectActivity = subjectActivity;
        this.subjectModelList = subjectModelList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_subject_item_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        SubjectModel subjectModel = subjectModelList.get(holder.getAdapterPosition());
        holder.txtSubject.setText(subjectModel.getSubjectName());
        final boolean[] checked = {false};
        holder.subjectLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checked[0]) {
                    checked[0] = false;
                    holder.checkBox.setChecked(false);
                    subjectActivity.subjectName.add(subjectModel.getSubjectName());
                } else {
                    checked[0] = true;
                    holder.checkBox.setChecked(true);
                    subjectActivity.subjectName.remove(subjectModel.getSubjectName());
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return subjectModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView txtSubject;
        MaterialCheckBox checkBox;
        LinearLayout subjectLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            txtSubject = itemView.findViewById(R.id.txtSubject);
            checkBox = itemView.findViewById(R.id.checkBox);
            subjectLayout = itemView.findViewById(R.id.subjectLayout);

        }
    }

}
