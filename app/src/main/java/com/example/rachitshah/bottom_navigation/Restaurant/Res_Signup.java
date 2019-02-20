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

import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
        gender=(EditText) findViewById(R.id.gen);

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
                Boolean notnull;

                notnull = isnotnull();

                if (notnull) {
                    savedata();
                    Intent it = new Intent(Res_Signup.this, Res_Profile.class);
                    startActivity(it);
                } else {
                    Toast toast = Toast.makeText(Res_Signup.this, "Something is Wrong", Toast.LENGTH_LONG);
                    toast.show();
                }


            }
        });

    }

    private Boolean isnotnull() {
        boolean notnull = false;
        String n, e, p, ph, add, licno, gen, o;
        n = rname.getText().toString();
        e = email.getText().toString();
        p = password.getText().toString();
        ph = mono.getText().toString();
        add = address.getText().toString();
        licno = lic.getText().toString();
        gen = gender.getText().toString();
        o = oname.getText().toString();
        String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
        CharSequence inputStr = e;

        Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(inputStr);
        Boolean check = true;
        if (n.length() == 0) {
            rname.setError("Restaurant name cannot be Empty");
            check = false;
        }
        if (o.length() == 0) {
            oname.setError("Owner Name cannot be Empty");
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
            password.setError("Password cannot be Empty");
            check = false;
        }
        if (ph.length() != 10) {
            mono.setError("Phone cannot be Empty");
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

    private void savedata() {
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
