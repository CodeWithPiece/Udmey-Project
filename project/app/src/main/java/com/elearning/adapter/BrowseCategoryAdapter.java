package com.elearning.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.elearning.R;
import com.elearning.views.fragment.CourseFragment;
import com.elearning.views.fragment.ExploreFragment;

public class BrowseCategoryAdapter extends RecyclerView.Adapter<BrowseCategoryAdapter.ViewHolder> {

    ExploreFragment exploreFragment;
    int rowIndex = -1;

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
            holder.subCategoryRecycler.setVisibility(View.VISIBLE);
            holder.imgArrow.setImageResource(R.drawable.down_arrow);
        } else {
            holder.subCategoryRecycler.setVisibility(View.GONE);
            holder.imgArrow.setImageResource(R.drawable.arrow_right);
        }

    }

    @Override
    public int getItemCount() {
        return 10;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        RecyclerView subCategoryRecycler;
        ImageView imgArrow;
        RelativeLayout categoryLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            categoryLayout = itemView.findViewById(R.id.categoryLayout);
            imgArrow = itemView.findViewById(R.id.imgArrow);
            subCategoryRecycler = itemView.findViewById(R.id.subCategoryRecycler);
            subCategoryRecycler.setLayoutManager(new LinearLayoutManager(itemView.getContext(), LinearLayoutManager.VERTICAL, false));

            subCategoryRecycler.setVisibility(View.GONE);

        }
    }

}
