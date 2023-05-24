package com.example.activitytofragment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddActivity extends AppCompatActivity {

    EditText uname_et, pass_et;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);


        uname_et = findViewById(R.id.et1);
        pass_et = findViewById(R.id.et2);
        btn = findViewById(R.id.button);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String uname = uname_et.getText().toString();
                String password = pass_et.getText().toString();

                DBHelper myDB = new DBHelper(AddActivity.this);

                myDB.addBook(new DataClass(uname,password
                ));


            }
        });
    }
}