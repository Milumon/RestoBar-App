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
import com.isil.restaurant.model.Food;
import com.squareup.picasso.Picasso;

import java.util.List;

public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.FoodViewHolder> {

    Context context;

    List<Food> foodlist;

    public FoodAdapter(Context context, List<Food> foodlist) {
        this.context = context;
        this.foodlist = foodlist;
    }

    @NonNull
    @Override
    public FoodViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new FoodViewHolder(LayoutInflater.from(context).inflate(R.layout.food_row_item , parent, false));

    }

    @Override
    public void onBindViewHolder(@NonNull FoodViewHolder holder, int position) {

        Picasso.get().load(foodlist.get(position).getImageURL()).into(holder.itemImage);
        // holder.itemImage.setImageResource(foodlist.get(position).getImageURL());

        holder.itemName.setText(foodlist.get(position).getName());
        holder.itemPrice.setText(foodlist.get(position).getPrice());
        holder.itemTime.setText(foodlist.get(position).getTime());
        holder.itemRating.setRating(Float.parseFloat(foodlist.get(position).getRating()));
        holder.itemDescription.setText(foodlist.get(position).getDescription());

    }

    @Override
    public int getItemCount() {
        return foodlist.size();
    }

    public static final class FoodViewHolder extends RecyclerView.ViewHolder{

        ImageView itemImage;
        TextView itemPrice, itemTime, itemName, itemDescription;
        RatingBar itemRating;

        public FoodViewHolder(@NonNull View itemView) {
            super(itemView);

            itemImage = itemView.findViewById(R.id.item_image);
            itemPrice = itemView.findViewById(R.id.item_price);
            itemTime = itemView.findViewById(R.id.item_noUsed);
            itemName = itemView.findViewById(R.id.item_name);
            itemRating = itemView.findViewById(R.id.ratingBar);
            itemDescription = itemView.findViewById(R.id.item_description);
        }
    }

}
