package com.example.healthplus;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

// 8- Creating and configuring This class (ADAPTER)
public class RecyclerViewAdaptery extends
        RecyclerView.Adapter<RecyclerViewAdaptery.ImageViewHolder> {

    // Variables
    Context mContext;
    List<row> mData;

    // Constructor
    public RecyclerViewAdaptery(Context mContext, List<row> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @NonNull
    @Override
    public ImageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //  ImageView Holder - Binding views
        // Creating RecyclerView Item Layout
        View view = LayoutInflater.from(mContext).
                inflate(R.layout.recyclerview_item,
                        parent, false);
        return new ImageViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ImageViewHolder holder, int position) {


        // USING GLIDE LIBRARY

        Glide.
                with(mContext)
                .load(mData.get(position).getImg())
                .into(holder.img);
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }


    public class ImageViewHolder extends RecyclerView.ViewHolder implements
            View.OnClickListener{

        ImageView img;

        public ImageViewHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.imageView);

            // Click Listeners
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {

            // click events on items
            if (getLayoutPosition() == 0){
                Toast.makeText(mContext,
                        "You Clicked me ",
                        Toast.LENGTH_SHORT).show();
            }

        }
    }
}