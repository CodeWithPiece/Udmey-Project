package com.elearning.views.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;

import com.elearning.R;
import com.elearning.adapter.MyCourseAdapter;

public class MyCourseFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_my_course, container, false);

        EditText edtSearch = view.findViewById(R.id.edtSearch);
        Animation animation = AnimationUtils.loadAnimation(getContext(), R.anim.move);
        edtSearch.startAnimation(animation);
        RecyclerView myCourseRecycler = view.findViewById(R.id.myCourseRecycler);
        MyCourseAdapter myCourseAdapter = new MyCourseAdapter(MyCourseFragment.this);
        myCourseRecycler.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        myCourseRecycler.setAdapter(myCourseAdapter);

        return view;
    }
}