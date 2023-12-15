package com.elearning.views.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.elearning.R;
import com.elearning.adapter.SubjectAdapter;
import com.elearning.model.SubjectModel;
import com.google.android.material.button.MaterialButton;

import java.util.ArrayList;
import java.util.List;

public class SubjectActivity extends AppCompatActivity {

    public List<String> subjectName = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subject);

        RecyclerView subjectRecycler = findViewById(R.id.subjectRecycler);
        MaterialButton btnContinue = findViewById(R.id.btnContinue);
        subjectRecycler.setLayoutManager(new LinearLayoutManager(SubjectActivity.this, LinearLayoutManager.VERTICAL, false));
        getSubjects(subjectRecycler);

        btnContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                
            }
        });

    }

    public void getSubjects(RecyclerView recyclerView) {
        List<SubjectModel> subjectModelList = new ArrayList<>();
        subjectModelList.add(new SubjectModel("Development"));
        subjectModelList.add(new SubjectModel("Business"));
        subjectModelList.add(new SubjectModel("IT &amp; Software"));
        subjectModelList.add(new SubjectModel("Official Productivity"));
        subjectModelList.add(new SubjectModel("Personal Development"));
        subjectModelList.add(new SubjectModel("Design"));
        subjectModelList.add(new SubjectModel("Marketing"));
        subjectModelList.add(new SubjectModel("Photography"));
        subjectModelList.add(new SubjectModel("Language"));
        subjectModelList.add(new SubjectModel("Music"));
        subjectModelList.add(new SubjectModel("Health &amp; Fitness"));
        subjectModelList.add(new SubjectModel("Life Style"));
        subjectModelList.add(new SubjectModel("Teaching &amp; Academics"));
        subjectModelList.add(new SubjectModel("Others"));
        SubjectAdapter subjectAdapter = new SubjectAdapter(SubjectActivity.this, subjectModelList);
        recyclerView.setAdapter(subjectAdapter);
    }

}