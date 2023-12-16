package com.elearning.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.elearning.R;
import com.elearning.views.activity.CourseDetailsActivity;

public class SectionAdapter extends RecyclerView.Adapter<SectionAdapter.ViewHolder> {

    CourseDetailsActivity courseDetailsActivity;

    public SectionAdapter(CourseDetailsActivity courseDetailsActivity) {
        this.courseDetailsActivity = courseDetailsActivity;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_section_item_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {


    }

    @Override
    public int getItemCount() {
        return 5;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        RecyclerView sectionRecycler;
        ImageView imgArrow;
        TextView txtCategoryName;
        RelativeLayout categoryLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            categoryLayout = itemView.findViewById(R.id.categoryLayout);
            imgArrow = itemView.findViewById(R.id.imgArrow);
            sectionRecycler = itemView.findViewById(R.id.sectionRecycler);
            txtCategoryName = itemView.findViewById(R.id.txtCategoryName);
            sectionRecycler.setLayoutManager(new LinearLayoutManager(itemView.getContext(), LinearLayoutManager.VERTICAL, false));
            sectionRecycler.setVisibility(View.GONE);

        }
    }

}
