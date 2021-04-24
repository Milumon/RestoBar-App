package com.isil.restaurant.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.isil.restaurant.R;
import com.isil.restaurant.model.Store;

import java.util.List;

public class StoreAdapter extends RecyclerView.Adapter<StoreAdapter.StoreViewHolder> {

    Context context;


    List<Store> storelist;

    public StoreAdapter(Context context, List<Store> storelist) {
        this.context = context;
        this.storelist = storelist;
    }


    @NonNull
    @Override
    public StoreViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new StoreViewHolder(LayoutInflater.from(context).inflate(R.layout.store_row_item , parent, false));

    }

    @Override
    public void onBindViewHolder(@NonNull StoreViewHolder holder, int position) {

        holder.itemImage.setImageResource(storelist.get(position).getImageURL());
        holder.itemName.setText(storelist.get(position).getName());
        holder.itemTime.setText(storelist.get(position).getTime());

    }

    @Override
    public int getItemCount() {
        return storelist.size();
    }

    public static final class StoreViewHolder extends RecyclerView.ViewHolder{


        ImageView itemImage;
        TextView itemTime, itemName;

        public StoreViewHolder(@NonNull View itemView) {
            super(itemView);

            itemImage = itemView.findViewById(R.id.item_image);
            itemTime = itemView.findViewById(R.id.item_time);
            itemName = itemView.findViewById(R.id.item_name);
        }
    }

}

 