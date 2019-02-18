package com.example.rachitshah.bottom_navigation.Restaurant;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.rachitshah.bottom_navigation.Main2Activity;
import com.example.rachitshah.bottom_navigation.R;

import org.w3c.dom.Text;

public class Res_Signup extends AppCompatActivity {
    TextView txt, sup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_res__signup);

        sup = (TextView) findViewById(R.id.rsup);
        txt = (TextView) findViewById(R.id.txt);
        sup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(Res_Signup.this, Res_Home.class);
                startActivity(it);
            }
        });

        txt.setOnClickListener(new View.OnClickListener() {
                                   @Override
                                   public void onClick(View v) {
                                       Intent it = new Intent(Res_Signup.this, Res_Login.class);
                                       startActivity(it);
                                   }
                               }

        );


    }
}
