package com.example.activitytofragment;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;


public class CustomDialog  extends Dialog {
    private TextView mTitleTextView;
    private EditText mMessageEditText;
    private Button mOkButton;

    public CustomDialog(@NonNull Context context) {
        super(context);
        setContentView(R.layout.custom_dialog);
        mTitleTextView = findViewById(R.id.title_textview);
        mMessageEditText = findViewById(R.id.message_edittext);
        mOkButton = findViewById(R.id.ok_button);
        mOkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // OK button clicked
                String message = mMessageEditText.getText().toString();
                Toast.makeText(context, "toast " + message, Toast.LENGTH_SHORT).show();

                dismiss(); // Close the dialog
            }
        });
    }
}
