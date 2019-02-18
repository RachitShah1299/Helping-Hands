package com.example.rachitshah.bottom_navigation;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.rachitshah.bottom_navigation.Recent_ListView.Rec_DataModel;
import com.example.rachitshah.bottom_navigation.Recent_ListView.Rec_MyBaseAdapter;

import java.util.ArrayList;


public class RecentFragment extends Fragment {
    ListView listView;
    String images[] = {"Sandwich House", "Jugaad Nights", "Kabir Restaurant", "Alimentos Restaurant"};
    int image[] = {R.drawable.res1, R.drawable.res1, R.drawable.res1, R.drawable.res1};
    String loc[] = {"S.G Highway", "Swastik Cross Road", "Drive in Road", "C.G Road"};
    String reqid[] = {"FD001", "FD002", "FD003", "FD004"};
    String don[] = {"04:29 Pm 03-02-19", "04:42 Pm 12-02-19", "08:15 Pm 02-02-19", "09:00 Am 02-02-19"};
    String dloc[] = {"Sal Hospital", "Gulbai Tekra", "Sal Hospital", "Abhujina"};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_recent, container, false);
        listView = (ListView) view.findViewById(R.id.Rec_liv);
        ArrayList<Rec_DataModel> Rec_DataModelArrayList = new ArrayList<Rec_DataModel>();

        for (int i = 0; i < images.length; i++) {
            Rec_DataModel Rec_DataModel = new Rec_DataModel(images[i], image[i], loc[i], reqid[i], don[i], dloc[i]);
            Rec_DataModelArrayList.add(Rec_DataModel);
        }
        Rec_MyBaseAdapter rec_MyBaseAdapter = new Rec_MyBaseAdapter(getActivity(), Rec_DataModelArrayList);
        listView.setAdapter(rec_MyBaseAdapter);
        return view;

    }

}