package com.isil.restaurant.adapter;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.isil.restaurant.R;
import com.isil.restaurant.model.Recommendation;

import java.util.List;

public class RecommendationAdapter extends RecyclerView.Adapter<RecommendationAdapter.RecommendationViewHolder> {

    Context context;

    List<Recommendation> recommendationlist;

    public RecommendationAdapter(Context context, List<Recommendation> recommendationlist) {
        this.context = context;
        this.recommendationlist = recommendationlist;
    }


    @NonNull
    @Override
    public RecommendationViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new RecommendationViewHolder(LayoutInflater.from(context).inflate(R.layout.recommendation_row_item , parent, false));

    }

    @Override
    public void onBindViewHolder(@NonNull RecommendationViewHolder holder, int position) {

        holder.itemImage.setImageResource(recommendationlist.get(position).getImageURL());
        holder.itemName.setText(recommendationlist.get(position).getName());
        holder.itemPrice.setText(recommendationlist.get(position).getPrice());
        holder.itemTime.setText(recommendationlist.get(position).getTime());
        holder.itemRating.setRating(Float.parseFloat(recommendationlist.get(position).getRating()));

    }

    @Override
    public int getItemCount() {
        return recommendationlist.size();
    }

    public static final class RecommendationViewHolder extends RecyclerView.ViewHolder{


        ImageView itemImage;
        TextView itemPrice, itemTime, itemName;
        RatingBar itemRating;

        public RecommendationViewHolder(@NonNull View itemView) {
            super(itemView);

            itemImage = itemView.findViewById(R.id.item_image);
            itemPrice = itemView.findViewById(R.id.item_price);
            itemTime = itemView.findViewById(R.id.item_time);
            itemName = itemView.findViewById(R.id.item_name);
            itemRating = itemView.findViewById(R.id.ratingBar);
        }
    }

}
