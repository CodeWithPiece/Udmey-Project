package com.elearning.adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.elearning.R;
import com.elearning.views.activity.CourseDetailsActivity;
import com.elearning.views.fragment.CourseFragment;

public class CourseAdapter extends RecyclerView.Adapter<CourseAdapter.ViewHolder> {

    CourseFragment courseFragment;

    public CourseAdapter(CourseFragment courseFragment) {
        this.courseFragment = courseFragment;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_course_item_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.courseLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(courseFragment.getActivity(), CourseDetailsActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                courseFragment.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return 10;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        LinearLayout courseLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            courseLayout = itemView.findViewById(R.id.courseLayout);

        }
    }

}
