package com.example.rachitshah.bottom_navigation.Restaurant;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TextInputEditText;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.rachitshah.bottom_navigation.R;

import java.lang.reflect.Array;

public class Res_Profile extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    TextInputEditText rname, oname, email, phone, address, password;
    ImageView img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_res__profile);

        rname = (TextInputEditText) findViewById(R.id.rname);
        oname = (TextInputEditText) findViewById(R.id.oname);
        email = (TextInputEditText) findViewById(R.id.email);
        phone = (TextInputEditText) findViewById(R.id.phone);
        address =(TextInputEditText) findViewById(R.id.address);
        password =(TextInputEditText) findViewById(R.id.password);
        img = (ImageView) findViewById(R.id.profile);


        SharedPreferences sharedPreferences = getSharedPreferences("Restaurant", MODE_PRIVATE);
        rname.setText(sharedPreferences.getString("Rname", "???"));
        oname.setText(sharedPreferences.getString("Oname", "???"));
        email.setText(sharedPreferences.getString("Email", "???"));
        phone.setText(sharedPreferences.getString("Phone", "???"));
        address.setText(sharedPreferences.getString("Address", "???"));
        password.setText(sharedPreferences.getString("Password", "???"));
        img.setImageURI(Uri.parse(sharedPreferences.getString("Profile", "???")));
        

    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        return false;
    }
}
