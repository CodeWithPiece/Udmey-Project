package com.elearning.views.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.elearning.R;
import com.elearning.adapter.CurriculumAdapter;
import com.google.android.material.appbar.MaterialToolbar;

public class CourseDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_details);

        MaterialToolbar toolBar = findViewById(R.id.toolBar);
        RecyclerView curriculumRecycler = findViewById(R.id.curriculumRecycler);
        CurriculumAdapter curriculumAdapter = new CurriculumAdapter(CourseDetailsActivity.this);
        curriculumRecycler.setLayoutManager(new LinearLayoutManager(CourseDetailsActivity.this, LinearLayoutManager.VERTICAL, false));
        curriculumRecycler.setAdapter(curriculumAdapter);
        toolBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getOnBackPressedDispatcher().onBackPressed();
            }
        });

    }
}