package com.elearning.adapter;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.elearning.R;
import com.elearning.views.fragment.CourseFragment;
import com.elearning.views.fragment.ExploreFragment;
import com.elearning.views.fragment.SubCategoryFragment;

public class BrowseSubCategoryAdapter extends RecyclerView.Adapter<BrowseSubCategoryAdapter.ViewHolder> {

    ExploreFragment exploreFragment;

    public BrowseSubCategoryAdapter(ExploreFragment exploreFragment) {
        this.exploreFragment = exploreFragment;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_browse_sub_category_item_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.txtSubCategoryName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                exploreFragment.getParentFragmentManager()
                        .beginTransaction()
                        .replace(R.id.container, new SubCategoryFragment())
                        .commit();
                Bundle bundle = new Bundle();
                bundle.putString("data", "Sub-Category");
                exploreFragment.getParentFragmentManager().setFragmentResult("subCat", bundle);
            }
        });
    }

    @Override
    public int getItemCount() {
        return 5;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView txtSubCategoryName;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            txtSubCategoryName = itemView.findViewById(R.id.txtSubCategoryName);

        }
    }

}
