package com.example.activitytofragment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {
    private Context context;
    int position;
//    private ArrayList id, name, pass;
//private ArrayList id, name, pass;
    private   List<DataClass> contactList;
    private Activity activity;

    public CustomAdapter(Context context, List<DataClass> list,Activity activity) {
        this.context = context;
        this.contactList= list;
        this.activity = activity;

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
        holder.tv_pass.setText(String.valueOf(contact.getPass()));
        holder.tv_name.setText(String.valueOf(contact.getName()));
        holder.tv_pass.setText(String.valueOf(contact.getPass()));

        holder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,UpdateActivity.class);
                intent.putExtra("id",String.valueOf(contact.getId()));
                intent.putExtra("name",String.valueOf(contact.getName()));
                intent.putExtra("pass",String.valueOf(contact.getPass()));
//                context.startActivity(intent);
                activity.startActivityForResult(intent, 1);
            }
        });

    }

    @Override
    public int getItemCount() {
        return contactList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tv_id, tv_name, tv_pass;

        ConstraintLayout layout;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_id = itemView.findViewById(R.id.tv_id);
            tv_name = itemView.findViewById(R.id.tv_name);
            tv_pass = itemView.findViewById(R.id.tv_pass);
            layout = itemView.findViewById(R.id.rv_item);
        }
    }
}
