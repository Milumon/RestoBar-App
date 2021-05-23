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
import com.isil.restaurant.model.Recommendation;
import com.squareup.picasso.Picasso;

import java.util.List;

public class RecommendationFullAdapter extends RecyclerView.Adapter<RecommendationFullAdapter.RecommendationFullViewHolder> {

    Context context;

    List<Recommendation> recommendationFulllist;

    public RecommendationFullAdapter(Context context, List<Recommendation> recommendationFulllist) {
        this.context = context;
        this.recommendationFulllist = recommendationFulllist;
    }

    @NonNull
    @Override
    public RecommendationFullViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new RecommendationFullViewHolder(LayoutInflater.from(context).inflate(R.layout.recommendation_full_row_item , parent, false));

    }

    @Override
    public void onBindViewHolder(@NonNull RecommendationFullViewHolder holder, int position) {

        System.out.printf("GAAAAAAAAAAAAAAAAA"+holder);
        System.out.println(recommendationFulllist.get(position).getImageURL());
        Picasso.get().load(recommendationFulllist.get(position).getImageURL()).into(holder.itemImage);
        // holder.itemImage.setImageResource(recommendationFulllist.get(position).getImageURL());

        holder.itemName.setText(recommendationFulllist.get(position).getName());
        holder.itemPrice.setText(recommendationFulllist.get(position).getPrice());
        holder.itemTime.setText(recommendationFulllist.get(position).getTime());
        holder.itemRating.setRating(Float.parseFloat(recommendationFulllist.get(position).getRating()));
    }

    @Override
    public int getItemCount() {
        return recommendationFulllist.size();
    }

    public static final class RecommendationFullViewHolder extends RecyclerView.ViewHolder{

        ImageView itemImage;
        TextView itemPrice, itemTime, itemName;
        RatingBar itemRating;

        public RecommendationFullViewHolder(@NonNull View itemView) {
            super(itemView);

            itemImage = itemView.findViewById(R.id.item_image);
            itemPrice = itemView.findViewById(R.id.item_price);
            itemTime = itemView.findViewById(R.id.item_noUsed);
            itemName = itemView.findViewById(R.id.item_name);
            itemRating = itemView.findViewById(R.id.ratingBar);
        }
    }

}
