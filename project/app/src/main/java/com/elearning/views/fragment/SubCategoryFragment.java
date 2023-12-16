package com.elearning.views.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentResultListener;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.elearning.R;
import com.google.android.material.appbar.MaterialToolbar;

public class SubCategoryFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_sub_category, container, false);

        MaterialToolbar materialToolbar = view.findViewById(R.id.toolBar);
        TextView txtSubCategoryName = view.findViewById(R.id.txtSubCategoryName);
        RecyclerView topicRecycler = view.findViewById(R.id.topicRecycler);
        topicRecycler.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        getParentFragmentManager().setFragmentResultListener("subCat", this, new FragmentResultListener() {
            @Override
            public void onFragmentResult(@NonNull String requestKey, @NonNull Bundle result) {
                String data = result.getString("data");
                txtSubCategoryName.setText(data);
            }
        });
        materialToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getParentFragmentManager()
                        .beginTransaction()
                        .replace(R.id.container, new ExploreFragment())
                        .commit();
            }
        });

        return view;
    }
}