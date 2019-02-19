package com.example.rachitshah.bottom_navigation;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class Signup extends AppCompatActivity {
    ImageView img;
    Uri imageUri;
    private static final int PICK_IMAGE = 100;
    EditText name, email, phone, pswd, address, lic;
    TextView lin, sup;
    String path;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        sup = (TextView) findViewById(R.id.sbtn);
        name = (EditText) findViewById(R.id.name);
        email = (EditText) findViewById(R.id.email);
        phone = (EditText) findViewById(R.id.mono);
        pswd = (EditText) findViewById(R.id.pass);
        address = (EditText) findViewById(R.id.add);
        lic = (EditText) findViewById(R.id.lic);
        img = (ImageView) findViewById(R.id.img);

        //Image Selector
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gallery = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
                startActivityForResult(gallery, PICK_IMAGE);
            }
        });

        //Signup Button Listener
        sup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Saving Data in Storage
                savedata();
                Intent it = new Intent(Signup.this, Main2Activity.class);
                startActivity(it);
            }

            private void savedata() {
                SharedPreferences sharedPreferences = getSharedPreferences("Volunteer", MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("Name", name.getText().toString());
                editor.putString("Email", email.getText().toString());
                editor.putString("Phone", phone.getText().toString());
                editor.putString("Address", address.getText().toString());
                editor.putString("lic", lic.getText().toString());
                editor.putString("Password", pswd.getText().toString());
                editor.putString("Profile", path);
                editor.commit();

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
