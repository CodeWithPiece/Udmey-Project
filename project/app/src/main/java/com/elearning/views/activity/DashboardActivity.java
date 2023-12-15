package com.elearning.views.activity;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.elearning.R;
import com.elearning.views.fragment.CourseFragment;
import com.elearning.views.fragment.ExploreFragment;
import com.elearning.views.fragment.FavouriteFragment;
import com.elearning.views.fragment.MyCourseFragment;
import com.elearning.views.fragment.ProfileFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class DashboardActivity extends AppCompatActivity {

    String currentFrag = "COURSE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        BottomNavigationView bottomNavigation = findViewById(R.id.bottomNavigation);
        loadFragment(new CourseFragment());
        bottomNavigation.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId() == R.id.star) {
                    currentFrag = "COURSE";
                    loadFragment(new CourseFragment());
                    return true;
                } else if (item.getItemId() == R.id.search) {
                    currentFrag = "EXPLORE";
                    loadFragment(new ExploreFragment());
                    return true;
                } else if (item.getItemId() == R.id.play) {
                    currentFrag = "MY COURSE";
                    loadFragment(new MyCourseFragment());
                    return true;
                } else if (item.getItemId() == R.id.heart) {
                    currentFrag = "FAVOURITE";
                    loadFragment(new FavouriteFragment());
                    return true;
                } else if (item.getItemId() == R.id.profile) {
                    currentFrag = "PROFILE";
                    loadFragment(new ProfileFragment());
                    return true;
                }
                return false;
            }
        });
    }

    public void loadFragment(Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.container, fragment)
                .commit();
    }
}