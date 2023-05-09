package com.example.activitytofragment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    final ArrayList<DataModel> mDataModel;

    public RecyclerViewAdapter(ArrayList<DataModel> mDataModel) {
        this.mDataModel = mDataModel;
    }

    @NonNull
    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycler_view_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter.ViewHolder holder, int position) {
        DataModel dataModel = mDataModel.get(position);
        holder.mTextView.setText(dataModel.text);
        holder.mImageView.setImageResource(dataModel.images);


    }

    @Override
    public int getItemCount() {
        return mDataModel.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView mTextView;
        public ImageView mImageView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mTextView= itemView.findViewById(R.id.rc_item_tv);
            mImageView= itemView.findViewById(R.id.rc_item_iv);
        }
    }
}
