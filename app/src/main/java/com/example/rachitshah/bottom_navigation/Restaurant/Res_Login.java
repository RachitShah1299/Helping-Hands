package com.example.rachitshah.bottom_navigation.Restaurant;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.rachitshah.bottom_navigation.Forgotpassword;
import com.example.rachitshah.bottom_navigation.Main2Activity;
import com.example.rachitshah.bottom_navigation.R;

public class Res_Login extends AppCompatActivity {
    TextView lin, fpass, signup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN); //show the activity in full screen

        setContentView(R.layout.activity_res__login);

        fpass = findViewById(R.id.res_forg_pass);
        lin = findViewById(R.id.lin);
        signup = findViewById(R.id.sup);

        lin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(Res_Login.this, Res_Home.class);
                startActivity(it);
            }
        });

        fpass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(Res_Login.this, Forgotpassword.class);
                startActivity(it);
            }
        });

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent  = new Intent(Res_Login.this, Res_Signup.class);
                startActivity(intent);

            }
        });


    }

}
