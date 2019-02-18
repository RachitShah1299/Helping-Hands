package com.example.rachitshah.bottom_navigation;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;



public class Main2Activity extends AppCompatActivity {

    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener;

    {
        mOnNavigationItemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {

            Fragment fragment;
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.navigation_home:
                        fragment =new HomeFragment();
                        FragmentManager home_fm = getSupportFragmentManager();
                        FragmentTransaction home_ft = home_fm.beginTransaction();
                        home_ft.replace(R.id.fragment_f, fragment);
                        home_ft.commit();
                        return true;

                    case R.id.navigation_recents:
                        fragment =new RecentFragment();
                        FragmentManager recent_fm = getSupportFragmentManager();
                        FragmentTransaction recent_ft = recent_fm.beginTransaction();
                        recent_ft.replace(R.id.fragment_f, fragment);
                        recent_ft.commit();
                        return true;

                    case R.id.navigation_profile:
                        fragment =new profileFragment();
                        FragmentManager profile_fm = getSupportFragmentManager();
                        FragmentTransaction profile_ft = profile_fm.beginTransaction();
                        profile_ft.replace(R.id.fragment_f, fragment);
                        profile_ft.commit();
                        return true;
                }
                return false;
            }
        };
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

}
