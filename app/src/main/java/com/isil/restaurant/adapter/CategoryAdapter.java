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
import com.isil.restaurant.model.Category;
import com.squareup.picasso.Picasso;

import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoriasViewHolder> {

    Context context;


    List<Category> categoriesList;

    public CategoryAdapter(Context context, List<Category> categoriesList) {
        this.context = context;
        this.categoriesList = categoriesList;
    }


    @NonNull
    @Override
    public CategoriasViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CategoriasViewHolder(LayoutInflater.from(context).inflate(R.layout.item_category , parent, false));

    }

    @Override
    public void onBindViewHolder(@NonNull CategoriasViewHolder holder, int position) {


        holder.item_name1.setText(categoriesList.get(position).getID());
        holder.item_name2.setText(categoriesList.get(position).getnombre());
        Picasso.get().load(categoriesList.get(position).getUrlImagen()).into(holder.item_name3);



    }

    @Override
    public int getItemCount() {
        return categoriesList.size();
    }

    public static final class CategoriasViewHolder extends RecyclerView.ViewHolder{


         ImageView item_name3;
         TextView item_name1,item_name2;

        public CategoriasViewHolder(@NonNull View itemView) {
            super(itemView);


            item_name1 = itemView.findViewById(R.id.item_name1);
            item_name2 = itemView.findViewById(R.id.item_name2);
            item_name3 = itemView.findViewById(R.id.item_image);


        }
    }

}

