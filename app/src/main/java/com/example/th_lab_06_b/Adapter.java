package com.example.th_lab_06_b;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<ViewHolder> {
    private final List<product> productList;
    private Context context;
    private LayoutInflater inflater;
    private DataBaseP db;
    public Adapter(List<product> productList, MainActivity context){
        this.productList= productList;
        this.context = context;
        inflater = LayoutInflater.from(context);
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View pView = inflater.inflate(R.layout.item_list,parent,false);
        ViewHolder viewHolder = new ViewHolder(pView, this);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        db = DataBaseP.getInstance(context);
        product p = productList.get(position);
        holder.stt.setText(p.id+".");
        holder.place.setText(p.place);

        holder.btnXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                product p = productList.get(holder.getAbsoluteAdapterPosition());
                db.pDao().delete(p);
                int index = holder.getAbsoluteAdapterPosition();
                productList.remove(index);
                notifyItemRemoved(index);
                notifyItemRangeChanged(index,productList.size());

            }
        });
        holder.btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                product p = productList.get(holder.getAbsoluteAdapterPosition());
                Toast.makeText(context,""+p.place,Toast.LENGTH_SHORT).show();

            }
        });
    }


    @Override
    public int getItemCount() {
        return productList.size();
    }
}
