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
import android.view.WindowManager;

import com.example.rachitshah.bottom_navigation.Feedback;
import com.example.rachitshah.bottom_navigation.R;

public class Res_Feedback extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout mdrawer;
    private ActionBarDrawerToggle mtoogle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN); //show the activity in full screen

        setContentView(R.layout.activity_res__feedback);
        nav_menu();





    }

    private void nav_menu() {

        mdrawer = (DrawerLayout) findViewById(R.id.drawer);
        mtoogle = new ActionBarDrawerToggle(this, mdrawer, R.string.Open_Navigation, R.string.Close_Navigation);
        mdrawer.addDrawerListener(mtoogle);
        mtoogle.syncState();
        // getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        int id = menuItem.getItemId();

        if (id == R.id.res_home) {
            Intent intent = new Intent(Res_Feedback.this, Res_Home.class);
            startActivity(intent);
        } else if (id == R.id.res_recent) {
            Intent intent = new Intent(Res_Feedback.this, Res_Recent.class);
            startActivity(intent);
        } else if (id == R.id.res_profile) {
            Intent intent = new Intent(Res_Feedback.this, Res_Profile.class);
            startActivity(intent);

        } else if (id == R.id.res_feedback) {
            Intent intent = new Intent(Res_Feedback.this, Feedback.class);
            startActivity(intent);

        } else if (id == R.id.res_logout) {
            //Intent intent = new Intent(Res_Home.this, Res_Logout.class);
            //startActivity(intent);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
