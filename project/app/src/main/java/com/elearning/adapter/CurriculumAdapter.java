package com.elearning.adapter;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.elearning.R;
import com.elearning.views.activity.CourseDetailsActivity;
import com.elearning.views.fragment.ExploreFragment;

public class CurriculumAdapter extends RecyclerView.Adapter<CurriculumAdapter.ViewHolder> {

    CourseDetailsActivity courseDetailsActivity;
    int rowIndex = 0;

    public CurriculumAdapter(CourseDetailsActivity courseDetailsActivity) {
        this.courseDetailsActivity = courseDetailsActivity;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_curriculum_item_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        SectionAdapter sectionAdapter = new SectionAdapter(courseDetailsActivity);
        holder.sectionRecycler.setAdapter(sectionAdapter);
        holder.txtCurriculumName.setText("Section " + (position + 1) + " - Introduction");
        holder.categoryLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rowIndex = holder.getAdapterPosition();
                notifyDataSetChanged();
            }
        });

        if (rowIndex == holder.getAdapterPosition()) {
            Animation animation = AnimationUtils.loadAnimation(courseDetailsActivity, R.anim.move_down);
            holder.sectionRecycler.setVisibility(View.VISIBLE);
            holder.imgArrow.setImageResource(R.drawable.down_arrow);
            holder.sectionRecycler.startAnimation(animation);
        } else {
            holder.sectionRecycler.setVisibility(View.GONE);
            holder.imgArrow.setImageResource(R.drawable.arrow_right);
        }
    }

    @Override
    public int getItemCount() {
        return 5;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        RecyclerView sectionRecycler;
        TextView txtCurriculumName;
        ImageView imgArrow;
        RelativeLayout categoryLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            categoryLayout = itemView.findViewById(R.id.categoryLayout);
            imgArrow = itemView.findViewById(R.id.imgArrow);
            txtCurriculumName = itemView.findViewById(R.id.txtCurriculumName);
            sectionRecycler = itemView.findViewById(R.id.sectionRecycler);
            sectionRecycler.setLayoutManager(new LinearLayoutManager(itemView.getContext(), LinearLayoutManager.VERTICAL, false));
            sectionRecycler.setVisibility(View.GONE);

        }
    }

}
