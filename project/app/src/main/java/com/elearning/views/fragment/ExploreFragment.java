package com.elearning.views.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;

import com.elearning.R;

public class ExploreFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_explore, container, false);

        EditText edtSearch = view.findViewById(R.id.edtSearch);
        Animation animation = AnimationUtils.loadAnimation(getContext(), R.anim.move);
        edtSearch.startAnimation(animation);

        return view;
    }
}