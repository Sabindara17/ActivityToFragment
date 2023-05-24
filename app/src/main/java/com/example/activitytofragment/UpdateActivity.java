package com.example.activitytofragment;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateActivity extends AppCompatActivity {
    EditText uname_et , pass_et;
    Button btn;

    String id, name , pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        uname_et = findViewById(R.id.et1);
        pass_et = findViewById(R.id.et2);
        btn= findViewById(R.id.button);
        getIntetData();
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper dbHelper =new DBHelper(UpdateActivity.this);

                dbHelper.updateData(new DataClass("s","u"),id);

            }
        });


    }

    void getIntetData(){
        if(getIntent().hasExtra("name")){
            name = getIntent().getStringExtra("name");
            pass = getIntent().getStringExtra("pass");
            id = getIntent().getStringExtra("id");
            Log.d("ID", "getIntetData: "+id);
            uname_et.setText(name);
            pass_et.setText(pass);

        }else{
            Toast.makeText(this, "No data!!!", Toast.LENGTH_SHORT).show();
        }
    }
}