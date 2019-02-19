package com.example.rachitshah.bottom_navigation.Restaurant;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.rachitshah.bottom_navigation.Main2Activity;
import com.example.rachitshah.bottom_navigation.R;
import com.example.rachitshah.bottom_navigation.Signup;

import org.w3c.dom.Text;

import de.hdodenhof.circleimageview.CircleImageView;

public class Res_Signup extends AppCompatActivity {
    String path;
    Uri imageUri;
    ImageView img;
    TextView txt, sup;
    private static final int PICK_IMAGE = 100;
    EditText rname, oname, email, password, mono, address, gender, birthdate, lic;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_res__signup);

        sup = (TextView) findViewById(R.id.sbtn);
        txt = (TextView) findViewById(R.id.txt);
        rname = (EditText) findViewById(R.id.rname);
        oname = (EditText) findViewById(R.id.oname);
        img = (ImageView) findViewById(R.id.profile);
        email = (EditText) findViewById(R.id.email);
        password = (EditText) findViewById(R.id.pass);
        mono = (EditText) findViewById(R.id.mono);
        address = (EditText) findViewById(R.id.add);
        lic = (EditText) findViewById(R.id.lic);


        txt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Res_Signup.this, Res_Login.class);
                startActivity(intent);
            }
        });

        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gallery = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
                startActivityForResult(gallery, PICK_IMAGE);
            }
        });


        sup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences = getSharedPreferences("Restaurant", MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("Rname", rname.getText().toString());
                editor.putString("Oname", oname.getText().toString());
                editor.putString("Email", email.getText().toString());
                editor.putString("Phone", mono.getText().toString());
                editor.putString("Address", address.getText().toString());
                editor.putString("Password", password.getText().toString());
                editor.putString("Lic", lic.getText().toString());
                editor.putString("Profile", path);

                editor.commit();
                Intent it = new Intent(Res_Signup.this, Res_Profile.class);
                startActivity(it);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && requestCode == PICK_IMAGE) {
            imageUri = data.getData();
            img.setImageURI(imageUri);
            path = String.valueOf(imageUri);
        }
    }

}
