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
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Signup extends AppCompatActivity {
    ImageView img;
    Uri imageUri;
    private static final int PICK_IMAGE = 100;
    EditText name, email, phone, pswd, address, lic, gender;
    TextView lin, sup;
    String path;
    String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";


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
        gender = (EditText) findViewById(R.id.gen);
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
                Boolean notnull;

                notnull = isnotnull();

                if (notnull) {
                    savedata();
                    Intent it = new Intent(Signup.this, Main2Activity.class);
                    startActivity(it);
                } else {
                    Toast toast = Toast.makeText(Signup.this, "Something is Wrong", Toast.LENGTH_LONG);
                    toast.show();
                }
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
                editor.putString("Gender", gender.getText().toString());
                editor.putString("Profile", path);
                editor.commit();

            }
        });

    }

    private Boolean isnotnull() {
        boolean notnull = false;
        String n, e, p, ph, add, licno, gen;
        n = name.getText().toString();
        e = email.getText().toString();
        p = pswd.getText().toString();
        ph = phone.getText().toString();
        add = address.getText().toString();
        licno = lic.getText().toString();
        gen  = gender.getText().toString();
        String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
        CharSequence inputStr = e;

        Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(inputStr);
        Boolean check = true;
        if (n.length() == 0) {
            name.setError("Name cannot be Empty");
            check = false;
        }
        if (gen.length() == 0) {
            gender.setError("Gender cannot be Empty");
            check = false;
        }



        if (!matcher.matches()) {
            email.setError("Email not Valid");
            check = false;
        }
        if (p.length() == 0) {
            pswd.setError("Password cannot be Empty");
            check = false;
        }
        if (ph.length() != 10) {
            phone.setError("Phone cannot be Empty");
            check = false;
        }
        if (add.length() == 0) {
            address.setError("Address cannot be Empty");
            check = false;
        }
        if (licno.length() == 0) {
            lic.setError("License cannot be Empty");
            check = false;
        }
        if (check == true) {
            return true;
        } else {
            return false;
        }
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
