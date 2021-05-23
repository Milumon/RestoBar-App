package com.isil.restaurant.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.isil.restaurant.R;
import com.isil.restaurant.model.Employee;

import java.util.List;

public class EmployeeAdapter extends RecyclerView.Adapter<EmployeeAdapter.ServiciosViewHolder> {

    Context context;


    List<Employee> employeeslist;

    public EmployeeAdapter(Context context, List<Employee> employeeslist) {
        this.context = context;
        this.employeeslist = employeeslist;
    }


    @NonNull
    @Override
    public ServiciosViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ServiciosViewHolder(LayoutInflater.from(context).inflate(R.layout.item_collaborators, parent, false));

    }

    @Override
    public void onBindViewHolder(@NonNull ServiciosViewHolder holder, int position) {


        holder.item_name1.setText(employeeslist.get(position).getID());
        holder.item_name2.setText(employeeslist.get(position).getNombres());
        holder.item_name3.setText(employeeslist.get(position).getApellidos());
        holder.item_name4.setText(employeeslist.get(position).getCargo());
        holder.item_name5.setText(employeeslist.get(position).getfecha());

    }

    @Override
    public int getItemCount() {
        return employeeslist.size();
    }

    public static final class ServiciosViewHolder extends RecyclerView.ViewHolder{



        TextView item_name1,item_name2,item_name3,item_name4,item_name5;

        public ServiciosViewHolder(@NonNull View itemView) {
            super(itemView);

            item_name1 = itemView.findViewById(R.id.item_name1);
            item_name2 = itemView.findViewById(R.id.item_name2);
            item_name3 = itemView.findViewById(R.id.item_name3);
            item_name4 = itemView.findViewById(R.id.item_name4);
            item_name5 = itemView.findViewById(R.id.item_name5);

        }
    }

}

