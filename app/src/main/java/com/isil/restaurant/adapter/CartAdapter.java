package com.isil.restaurant.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.isil.restaurant.R;
import com.isil.restaurant.model.Cart;
import com.squareup.picasso.Picasso;

import java.util.List;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.CartViewHolder> {

    Context context;

    List<Cart> cartlist;

    public CartAdapter(Context context, List<Cart> cartlist) {
        this.context = context;
        this.cartlist = cartlist;
    }

    @NonNull
    @Override
    public CartViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CartViewHolder(LayoutInflater.from(context).inflate(R.layout.cart_row_item , parent, false));

    }

    @Override
    public void onBindViewHolder(@NonNull CartViewHolder holder, int position) {

        Picasso.get().load(cartlist.get(position).getImageURL()).into(holder.itemImage);
        // holder.itemImage.setImageResource(cartlist.get(position).getImageURL());

        holder.itemName.setText(cartlist.get(position).getName());
        holder.itemPrice.setText(cartlist.get(position).getPrice());
        holder.itemQuantity.setText(cartlist.get(position).getQuantity());

    }

    @Override
    public int getItemCount() {
        return cartlist.size();
    }

    public static final class CartViewHolder extends RecyclerView.ViewHolder{

        ImageView itemImage;
        TextView itemPrice, itemQuantity, itemName;

        public CartViewHolder(@NonNull View itemView) {
            super(itemView);

            itemImage = itemView.findViewById(R.id.item_image);
            itemPrice = itemView.findViewById(R.id.item_price);
            itemQuantity = itemView.findViewById(R.id.item_cantity);
            itemName = itemView.findViewById(R.id.item_name);
        }
    }

}
