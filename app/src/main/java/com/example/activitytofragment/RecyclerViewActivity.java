package com.example.activitytofragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class RecyclerViewActivity extends AppCompatActivity {

    ArrayList<DataModel> dataModels = new ArrayList<DataModel>();

    RecyclerView recyclerView;
    RecyclerViewAdapter recyclerViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);
        recyclerView = findViewById(R.id.rc_view);
        ///
        populateData();
        ///
        recyclerViewAdapter= new RecyclerViewAdapter(dataModels);

        recyclerView.setLayoutManager(new GridLayoutManager(this,3));
        recyclerView.setAdapter(recyclerViewAdapter);

    }

    void populateData(){
        dataModels.add(new DataModel("Text 1",R.drawable.ic_launcher_background));
        dataModels.add(new DataModel("Text 2",R.drawable.ic_launcher_background));
        dataModels.add(new DataModel("Text 3",R.drawable.ic_launcher_background));
        dataModels.add(new DataModel("Text 4",R.drawable.ic_launcher_background));
        dataModels.add(new DataModel("Text 5",R.drawable.ic_launcher_background));
        dataModels.add(new DataModel("Text 6",R.drawable.ic_launcher_background));
    }
}