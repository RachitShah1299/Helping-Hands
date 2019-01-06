package com.example.rachitshah.bottom_navigation;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class Login extends AppCompatActivity {

    EditText pswd,usrusr;
    TextView sup,lin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        lin = findViewById(R.id.lin);
        usrusr = findViewById(R.id.usrusr);
        pswd = findViewById(R.id.pswrdd);
        sup = findViewById(R.id.sup);
        /*
        Typeface custom_font = Typeface.createFromAsset(getAssets(), "fonts/LatoLight.ttf");

        Typeface custom_font1 = Typeface.createFromAsset(getAssets(), "fonts/LatoRegular.ttf");
        lin.setTypeface(custom_font1);
        sup.setTypeface(custom_font);
        usrusr.setTypeface(custom_font);
        pswd.setTypeface(custom_font);
        */
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

    }
}
