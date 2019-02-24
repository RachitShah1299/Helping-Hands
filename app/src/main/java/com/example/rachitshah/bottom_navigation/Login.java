package com.example.rachitshah.bottom_navigation;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class Login extends AppCompatActivity {

    EditText pswd,usrusr;
    TextView sup,lin, forgotpass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN); //show the activity in full screen

        setContentView(R.layout.activity_login);
        forgotpass = (TextView) findViewById(R.id.forgot_pass);
        lin = findViewById(R.id.lin);
        usrusr = findViewById(R.id.usrusr);
        pswd = findViewById(R.id.pswrdd);
        sup = findViewById(R.id.sup);
        sup.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent it = new Intent(Login.this, Signup.class);
                startActivity(it);
            }
        });

        lin.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent it = new Intent(Login.this, Main2Activity.class);
                startActivity(it);
            }
        });

        forgotpass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login.this, Forgotpassword.class);
                startActivity(intent);
            }
        });

    }
}
