package com.elearning.views.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.elearning.R;
import com.elearning.adapter.CategoryAdapter;
import com.elearning.adapter.CourseAdapter;

public class CourseFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_course, container, false);

        RecyclerView categoryRecycler = view.findViewById(R.id.categoryRecycler);
        RecyclerView courseRecycler = view.findViewById(R.id.courseRecycler);
        CategoryAdapter categoryAdapter = new CategoryAdapter(CourseFragment.this);
        CourseAdapter courseAdapter = new CourseAdapter(CourseFragment.this);
        courseRecycler.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        categoryRecycler.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        categoryRecycler.setAdapter(categoryAdapter);
        courseRecycler.setAdapter(courseAdapter);

        return view;
    }
}