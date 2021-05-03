package com.isil.restaurant.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.isil.restaurant.R;
import com.isil.restaurant.model.Store;
import com.squareup.picasso.Picasso;

import java.util.List;

public class StoreFullAdapter extends RecyclerView.Adapter<StoreFullAdapter.StoreFullViewHolder> {

    Context context;

    List<Store> storeFulllist;

    public StoreFullAdapter(Context context, List<Store> storeFulllist) {
        this.context = context;
        this.storeFulllist = storeFulllist;
    }

    @NonNull
    @Override
    public StoreFullViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new StoreFullViewHolder(LayoutInflater.from(context).inflate(R.layout.store_full_row_item , parent, false));

    }

    @Override
    public void onBindViewHolder(@NonNull StoreFullViewHolder holder, int position) {

        Picasso.get().load(storeFulllist.get(position).getImageURL()).into(holder.itemImage);
        // holder.itemImage.setImageResource(foodlist.get(position).getImageURL());
        holder.itemName.setText(storeFulllist.get(position).getName());
        holder.itemCapacidad.setText(storeFulllist.get(position).getCapacidad());
        holder.itemDireccion.setText(storeFulllist.get(position).getDireccion());


    }

    @Override
    public int getItemCount() {
        return storeFulllist.size();
    }

    public static final class StoreFullViewHolder extends RecyclerView.ViewHolder{

        ImageView itemImage;
        TextView itemName, itemCapacidad, itemDireccion;

        public StoreFullViewHolder(@NonNull View itemView) {
            super(itemView);

            itemImage = itemView.findViewById(R.id.item_image);
            itemName = itemView.findViewById(R.id.item_name);
            itemCapacidad = itemView.findViewById(R.id.item_capacidad);
            itemDireccion = itemView.findViewById(R.id.item_direccion);


        }
    }

}
