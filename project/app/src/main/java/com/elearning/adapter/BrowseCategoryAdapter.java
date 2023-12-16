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
import com.elearning.views.fragment.CourseFragment;
import com.elearning.views.fragment.ExploreFragment;

public class BrowseCategoryAdapter extends RecyclerView.Adapter<BrowseCategoryAdapter.ViewHolder> {

    ExploreFragment exploreFragment;
    int rowIndex = 0;

    public BrowseCategoryAdapter(ExploreFragment exploreFragment) {
        this.exploreFragment = exploreFragment;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_browse_category_item_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        BrowseSubCategoryAdapter browseSubCategoryAdapter = new BrowseSubCategoryAdapter(exploreFragment);
        holder.subCategoryRecycler.setAdapter(browseSubCategoryAdapter);
        holder.categoryLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rowIndex = holder.getAdapterPosition();
                notifyDataSetChanged();
            }
        });

        if (rowIndex == holder.getAdapterPosition()) {
            Animation animation = AnimationUtils.loadAnimation(exploreFragment.getContext(), R.anim.move_down);
            holder.subCategoryRecycler.setVisibility(View.VISIBLE);
            holder.imgArrow.setImageResource(R.drawable.down_arrow);
            holder.subCategoryRecycler.startAnimation(animation);
            holder.txtCategoryName.setTextColor(exploreFragment.getContext().getColor(R.color.md_theme_light_primary));
        } else {
            holder.subCategoryRecycler.setVisibility(View.GONE);
            holder.imgArrow.setImageResource(R.drawable.arrow_right);
            holder.txtCategoryName.setTextColor(Color.BLACK);
        }

    }

    @Override
    public int getItemCount() {
        return 5;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        RecyclerView subCategoryRecycler;
        ImageView imgArrow;
        TextView txtCategoryName;
        RelativeLayout categoryLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            categoryLayout = itemView.findViewById(R.id.categoryLayout);
            imgArrow = itemView.findViewById(R.id.imgArrow);
            subCategoryRecycler = itemView.findViewById(R.id.subCategoryRecycler);
            txtCategoryName = itemView.findViewById(R.id.txtCategoryName);
            subCategoryRecycler.setLayoutManager(new LinearLayoutManager(itemView.getContext(), LinearLayoutManager.VERTICAL, false));
            subCategoryRecycler.setVisibility(View.GONE);

        }
    }

}
