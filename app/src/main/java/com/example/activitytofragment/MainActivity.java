package com.example.activitytofragment;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupMenu;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btn, menu_btn,dialog_btn,custom_dialog;
    One fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragment = new One();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_fg, fragment)
                .commit();

        btn = findViewById(R.id.fragment_abtn);
        menu_btn = findViewById(R.id.menu_btn);
        dialog_btn = findViewById(R.id.dialog_btn);
        custom_dialog = findViewById(R.id.dialog_custom_btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText editText = findViewById(R.id.fragment_et);
                String text = editText.getText().toString();
                fragment.updateText(text);

            }
        });

        menu_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                PopupMenu popup = new PopupMenu(MainActivity.this, v);
                popup.inflate(R.menu.my);
                popup.show();
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        int id = item.getItemId();
                        if (id == R.id.menu_item1) {
                            Toast.makeText(MainActivity.this, "toast " + item.toString(), Toast.LENGTH_SHORT).show();

                            return true;
                        } else if (id == R.id.menu_item2) {
                            Toast.makeText(MainActivity.this, "toast " + item.toString(), Toast.LENGTH_SHORT).show();

                            return true;
                        }
                        return false;
                    }
                });


            }
        });

        dialog_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment dialogFragment = new com.example.activitytofragment.DialogFragment();
                dialogFragment.show(getSupportFragmentManager(), "d");
            }
        });

        custom_dialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CustomDialog customDialog = new CustomDialog(MainActivity.this);
               customDialog.setCancelable(false
               );
                customDialog.show();
            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.my, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.menu_item1) {
            Toast.makeText(MainActivity.this, "toast " + item.toString(), Toast.LENGTH_SHORT).show();
            return true;
        } else if (id == R.id.menu_item2) {
            Toast.makeText(MainActivity.this, "toast " + item.toString(), Toast.LENGTH_SHORT).show();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}