package com.example.rachitshah.bottom_navigation.Restaurant;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.rachitshah.bottom_navigation.R;

public class Res_Profile extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout mdrawer;
    private ActionBarDrawerToggle mtoogle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_res__profile);


    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        return false;
    }
}
