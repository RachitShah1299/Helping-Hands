package com.example.rachitshah.bottom_navigation;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import static android.content.Context.MODE_PRIVATE;
import static android.widget.Toast.LENGTH_LONG;


public class profileFragment extends Fragment {
    String path;
    Uri imageUri;
    ImageView img;
    ImageButton save;
    private static final int PICK_IMAGE = 100;
    TextInputEditText email, add, pswd, phone, name;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        name = (TextInputEditText) view.findViewById(R.id.name);
        email = (TextInputEditText) view.findViewById(R.id.prof_email);
        add = (TextInputEditText) view.findViewById(R.id.prof_address);
        pswd = (TextInputEditText) view.findViewById(R.id.prof_pswd);
        phone = (TextInputEditText) view.findViewById(R.id.prof_phone);
        img = (ImageView) view.findViewById(R.id.profile);
        save = (ImageButton) view.findViewById(R.id.save);



        getdata();
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                savedata();
            }
        });
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gallery = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
                startActivityForResult(gallery, PICK_IMAGE);

            }
        });


        return view;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == getActivity().RESULT_OK && requestCode == PICK_IMAGE) {
            imageUri = data.getData();
            img.setImageURI(imageUri);
            path = String.valueOf(imageUri);
        }
    }

    private void savedata() {

        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("Volunteer", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("Name", name.getText().toString());
        editor.putString("Email", email.getText().toString());
        editor.putString("Phone", phone.getText().toString());
        editor.putString("Address", add.getText().toString());
        editor.putString("Password", pswd.getText().toString());
        editor.putString("Profile", path);
        editor.commit();

        Toast toast = Toast.makeText(getActivity(), "Profile Updated Successfully", Toast.LENGTH_SHORT);
        toast.show();

    }

    private void getdata() {

        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("Volunteer", MODE_PRIVATE);
        name.setText(sharedPreferences.getString("Name", "???"));
        email.setText(sharedPreferences.getString("Email", "???"));
        pswd.setText(sharedPreferences.getString("Password", "???"));
        add.setText(sharedPreferences.getString("Address", "???"));
        phone.setText(sharedPreferences.getString("Phone", "???"));
        img.setImageURI(Uri.parse(sharedPreferences.getString("Profile", "???")));

    }

}
