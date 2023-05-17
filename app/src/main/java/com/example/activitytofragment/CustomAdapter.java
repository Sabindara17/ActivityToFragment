package com.example.activitytofragment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {
    private Context context;
//    private ArrayList id, name, pass;
private List<DataClass> contactList;

    public CustomAdapter(Context context, List<DataClass> contactList) {
        this.context = context;
        this.contactList = contactList;
    }


    @NonNull
    @Override
    public CustomAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.rv_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomAdapter.MyViewHolder holder, int position) {
        DataClass contact = contactList.get(position);
        holder.tv_id.setText(String.valueOf(contact.getId()));
        holder.tv_name.setText(String.valueOf(contact.getName()));
        holder.tv_pass.setText(String.valueOf(contact.getPass()));

    }

    @Override
    public int getItemCount() {
        return contactList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tv_id, tv_name, tv_pass;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_id = itemView.findViewById(R.id.tv_id);
            tv_name = itemView.findViewById(R.id.tv_name);
            tv_pass = itemView.findViewById(R.id.tv_pass);
        }
    }
}
