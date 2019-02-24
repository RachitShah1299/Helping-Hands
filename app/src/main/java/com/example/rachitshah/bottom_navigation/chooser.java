package com.example.rachitshah.bottom_navigation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

import com.example.rachitshah.bottom_navigation.Restaurant.Res_Login;

public class chooser extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //requestWindowFeature(Window.FEATURE_NO_TITLE);//will hide the title
       // getSupportActionBar().hide(); //hide the title bar

        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN); //show the activity in full screen


        setContentView(R.layout.activity_chooser);

        ImageView img1, img2;
        img1 = (ImageView) findViewById(R.id.Res);
        img2 = (ImageView) findViewById(R.id.Vol);


        img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(chooser.this, Res_Login.class);
                startActivity(intent);
            }
        });

        img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(chooser.this, Login.class);
                startActivity(intent);
            }
        });



    }
}
