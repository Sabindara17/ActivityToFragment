package com.example.activitytofragment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText txt;
    Button btn;
    String value;
    One first;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        first = new One();
        if(savedInstanceState==null){
            Bundle bun=new Bundle();
            bun.putString("key",value);


            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_fg,first).commit();

        }
        txt=findViewById(R.id.fragment_et);
        btn=findViewById(R.id.fragment_abtn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                value= txt.getText().toString();
                first.getData(value);

            }
        });
    }


}