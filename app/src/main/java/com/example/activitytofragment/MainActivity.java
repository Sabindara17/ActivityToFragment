package com.example.activitytofragment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private MyAdapter adapter;
//    private final ArrayList<DataClass> data = new ArrayList<DataClass>();
 ArrayList<DataClass>  shyameList = new ArrayList<DataClass>();
    String tutorial[] = {
            "1",
            "2",
            "3",
            "4"
    };


    ArrayAdapter<String> arrayAdapter;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.list);
        shyameList.add(new DataClass(R.drawable.ic_launcher_background,"asdasdsadsa"));
        shyameList.add(new DataClass(R.drawable.ic_launcher_background,"kljklhgkjlhgk"));
//        data.add(new DataClass(R.drawable.ic_launcher_background, "asdasdasdas 1"));
//        data.add(new DataClass(R.drawable.ic_launcher_background, "asdasdasdas 1"));
//        data.add(new DataClass(R.drawable.ic_launcher_background, "asdasdasdas 1"));
//        data.add(new DataClass(R.drawable.ic_launcher_background, "asdasdasdas 1"));
//        data.add(new DataClass(R.drawable.ic_launcher_background, "asdasdasdas 1"));
//        data.add(new DataClass(R.drawable.ic_launcher_background, "asdasdasdas 1"));
//        data.add(new DataClass(R.drawable.ic_launcher_background, "asdasdasdas 1"));
//        data.add(new DataClass(R.drawable.ic_launcher_background, "asdasdasdas 1"));
//        data.add(new DataClass(R.drawable.ic_launcher_background, "Item 2"));
//        data.add(new DataClass(R.drawable.ic_launcher_background, "Item 3"));


       MyAdapter adapter= new MyAdapter(MainActivity.this,shyameList);
//        listView.setAdapter(adapter);

//      ArrayAdapter<String>  arrayAdapter= new ArrayAdapter<>(
//                this,
//               androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,
//                tutorial
//        );

        ArrayAdapter<String> rameAdapter = new ArrayAdapter<>(MainActivity.this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, tutorial);
        listView.setAdapter(rameAdapter);
//
//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                String item = arrayAdapter.getItem(position);
//                Toast.makeText(MainActivity.this, "Item :" +item, Toast.LENGTH_SHORT).show();
//
//            }
//        });

    }
}