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
import com.isil.restaurant.model.Transaction;
import com.squareup.picasso.Picasso;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class TransactionAdapter extends RecyclerView.Adapter<TransactionAdapter.TransactionViewHolder> {

    Context context;


    List<Transaction> transactionlist;

    public TransactionAdapter(Context context, List<Transaction> transactionlist) {
        this.context = context;
        this.transactionlist = transactionlist;
    }


    @NonNull
    @Override
    public TransactionAdapter.TransactionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new TransactionAdapter.TransactionViewHolder(LayoutInflater.from(context).inflate(R.layout.item_transactions , parent, false));

    }

    @Override
    public void onBindViewHolder(@NonNull TransactionAdapter.TransactionViewHolder holder, int position) {
        holder.itemId.setText(transactionlist.get(position).getIdmovimiento());
        holder.itemFecha.setText(transactionlist.get(position).getFecha());
        holder.itemDescripcion.setText(transactionlist.get(position).getDescripcion());
        holder.itemMonto.setText(String.format("%.2f", transactionlist.get(position).getMonto()));
        holder.itemMovimiento.setText(transactionlist.get(position).getMovimiento());
        System.out.println("VALIDACIOOOOOOOOOOOOOOOOOOON EQUAL" + transactionlist.get(position).getMovimiento().equals( "-1"));
        if (transactionlist.get(position).getMovimiento().equals("-1")) {
            holder.itemDescripcion.setTextColor(context.getResources().getColor(R.color.red_design));
        }
    }

    @Override
    public int getItemCount() {
        return transactionlist.size();
    }

    public static final class TransactionViewHolder extends RecyclerView.ViewHolder{

        TextView itemId, itemFecha, itemDescripcion, itemMonto, itemMovimiento;

        public TransactionViewHolder(@NonNull View itemView) {
            super(itemView);

            itemId = itemView.findViewById(R.id.tvMovimientoId);
            itemFecha = itemView.findViewById(R.id.tvMovimientoFecha);
            itemDescripcion = itemView.findViewById(R.id.tvMovimientoDescripcion);
            itemMonto = itemView.findViewById(R.id.tvMovimientoMonto);
            itemMovimiento = itemView.findViewById(R.id.tvMovimiento);
        }
    }

}

 