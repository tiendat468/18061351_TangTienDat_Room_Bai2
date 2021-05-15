package com.example.th_lab_06_b;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ViewHolder extends  RecyclerView.ViewHolder {
    public final TextView stt;
    public final TextView place;
    ImageButton btnXoa;
    ImageButton btnUpdate;
    final Adapter pAdapter;

    public ViewHolder(@NonNull View itemView, Adapter pAdapter) {
        super(itemView);
        stt = itemView.findViewById(R.id.stt);
        place = itemView.findViewById(R.id.place);
        btnXoa = itemView.findViewById(R.id.btnXoa);
        btnUpdate = itemView.findViewById(R.id.btnUpdate);
        this.pAdapter = pAdapter;
    }
}
