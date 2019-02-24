package com.example.rachitshah.bottom_navigation;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.ListView;

import com.example.rachitshah.bottom_navigation.Vol_Home.Vol_home_MyBaseAdapter;
import com.example.rachitshah.bottom_navigation.Vol_Home.Vol_home_datamodel;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    ListView listView;
    Vol_home_MyBaseAdapter myBaseAdapter;
    String images[] = {"Sandwich House", "Jugaad Nights", "Kabir Restaurant", "Alimentos Restaurant"};
    int image[] = {R.drawable.res1, R.drawable.res1, R.drawable.res1, R.drawable.res1};
    String loc[] = {"S.G Highway", "Swastik Cross Road", "Drive in Road", "C.G Road"};
    String reqid[] = {"FD001", "FD002", "FD003", "FD004"};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home, container, false);

        ImageButton btyes = (ImageButton) view.findViewById(R.id.yes);
        ImageButton btno = (ImageButton) view.findViewById(R.id.no);
        listView = (ListView) view.findViewById(R.id.vol_home_liv);
        ArrayList<Vol_home_datamodel> dataModelArrayList = new ArrayList<Vol_home_datamodel>();

        for (int i = 0; i < images.length; i++) {
            Vol_home_datamodel dataModel = new Vol_home_datamodel(images[i], image[i], loc[i], reqid[i]);
            dataModelArrayList.add(dataModel);
        }
        myBaseAdapter = new Vol_home_MyBaseAdapter(getActivity(), dataModelArrayList);

        listView.setAdapter(myBaseAdapter);

        return view;
    }
}
