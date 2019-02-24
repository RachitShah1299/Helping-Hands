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
import android.widget.ListView;

import com.example.rachitshah.bottom_navigation.Feedback;
import com.example.rachitshah.bottom_navigation.R;

import java.util.ArrayList;

public class Res_Recent extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout mdrawer;
    private ActionBarDrawerToggle mtoogle;
    ListView listView;
    String vname[] = {"Rachit Shah", "Ankit Mehta", "Anish Jain", "Rohil Singhal","Jay Trivedi"};
    String dloc[] = {"Sal Hospital", "Gulbai Tekra", "Sal Hospital", "Abhujina","Talwadina"};
    String reqid[] = {"FD001", "FD002", "FD003", "FD004","FD005"};
    String don[] = {"04:29 Pm 03-02-19", "04:42 Pm 12-02-19", "08:15 Pm 02-02-19", "09:00 Am 02-02-19","10:45 Am 01-01-19"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN); //show the activity in full screen

        setContentView(R.layout.activity_res__recent);

        listView = (ListView) findViewById(R.id.Res_rec_liv);
        ArrayList<Res_Rec_DataModel> dataModelArrayList = new ArrayList<Res_Rec_DataModel>();

        for (int i = 0; i < vname.length; i++) {
            Res_Rec_DataModel dataModel = new Res_Rec_DataModel(vname[i],dloc[i],reqid[i],don[i]);
            dataModelArrayList.add(dataModel);
        }
        Res_Rec_MyBaseAdapter myBaseAdapter = new Res_Rec_MyBaseAdapter(this, dataModelArrayList);

        listView.setAdapter(myBaseAdapter);




    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        return false;
    }
}
