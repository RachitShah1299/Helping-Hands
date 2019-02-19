package com.example.rachitshah.bottom_navigation;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;

import static android.content.Context.MODE_PRIVATE;


public class profileFragment extends Fragment {
    ImageView img;
    TextInputEditText email, add, pswd, phone;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        email = (TextInputEditText) view.findViewById(R.id.prof_email);
        add = (TextInputEditText) view.findViewById(R.id.prof_address);
        pswd = (TextInputEditText) view.findViewById(R.id.prof_pswd);
        phone = (TextInputEditText) view.findViewById(R.id.prof_phone);
        img = (ImageView) view.findViewById(R.id.profile);

        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("Volunteer", MODE_PRIVATE);

        email.setText(sharedPreferences.getString("Email", "!!!"));
        pswd.setText(sharedPreferences.getString("Password", "!!!"));
        add.setText(sharedPreferences.getString("Address", "!!!"));
        phone.setText(sharedPreferences.getString("Phone", "!!!"));
        img.setImageURI(Uri.parse(sharedPreferences.getString("Profile", "???")));

        return view;
    }


}
