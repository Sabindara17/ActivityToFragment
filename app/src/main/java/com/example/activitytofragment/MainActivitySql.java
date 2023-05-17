package com.example.activitytofragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivitySql extends AppCompatActivity {

    RecyclerView recyclerView;
    FloatingActionButton floatingActionButton;

    DBHelper dbHelper;

    ArrayList<String> uname, pass, id;
    private List<DataClass> contactList;
    CustomAdapter customAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_sql);
        recyclerView = findViewById(R.id.recyclerView);
        floatingActionButton = findViewById(R.id.add_button);
        dbHelper =new DBHelper(MainActivitySql.this);
        uname = new ArrayList<>();
        pass = new ArrayList<>();
        id = new ArrayList<>();
        contactList = new ArrayList<>();
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivitySql.this,AddActivity.class);
                startActivity(intent);

            }
        });
        populateData();
        customAdapter = new CustomAdapter(MainActivitySql.this,contactList);
        recyclerView.setAdapter(customAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivitySql.this));

    }

    void populateData(){
        List<DataClass> allContacts = dbHelper.getAllData();
        contactList.addAll(allContacts);

//        Cursor cursor =dbHelper.readAllData();
//        if(cursor.getCount() == 0){
//            Toast.makeText(this, "No Data Available!", Toast.LENGTH_SHORT).show();
//        }else{
//            while (cursor.moveToNext()){
//                id.add(cursor.getString(0));
//                uname.add(cursor.getString(1));
//                pass.add(cursor.getString(2));
//            }
//        }
    }
}