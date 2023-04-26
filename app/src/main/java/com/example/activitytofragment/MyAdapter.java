package com.example.activitytofragment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends ArrayAdapter<DataClass> {

    // invoke the suitable constructor of the ArrayAdapter class
    public MyAdapter(@NonNull Context context, ArrayList<DataClass> arrayList) {

        // pass the context and arrayList for the super
        // constructor of the ArrayAdapter class
        super(context, 0, arrayList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        // convertView which is recyclable view
        View currentItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);

        // get the position of the view from the ArrayAdapter
        DataClass currentNumberPosition = getItem(position);

        // then according to the position of the view assign the desired image for the same
        ImageView numbersImage = currentItemView.findViewById(R.id.imageView);
        numbersImage.setImageResource(currentNumberPosition.images);

        // then according to the position of the view assign the desired TextView 1 for the same
        TextView textView1 = currentItemView.findViewById(R.id.titleTextView);
        textView1.setText(currentNumberPosition.getText());


        // then return the recyclable view
        return currentItemView;
    }
}