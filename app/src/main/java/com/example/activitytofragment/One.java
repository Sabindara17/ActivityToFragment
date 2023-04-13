package com.example.activitytofragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class One extends Fragment {
    String d;
    TextView txt;
    View v;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v= inflater.inflate(R.layout.fragment_one, container, false);

        txt=v.findViewById(R.id.fragment_tv);

    return v;
    }
    public void getData(String data){
        txt.setText(data);
    }

}