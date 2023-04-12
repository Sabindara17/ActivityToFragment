package com.example.activitytofragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    Button btn;
    One fragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         fragment = new One();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_fg, fragment)
                .commit();

        btn= findViewById(R.id.fragment_abtn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText editText = findViewById(R.id.fragment_et);
                String text = editText.getText().toString();
                fragment.updateText(text);

            }
        });

    }


}