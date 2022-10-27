package com.example.useaapp.GUEST.Program.associative;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.useaapp.GUEST.Program.bachelor.Response_model_guest_program_faculty_bachelor;
import com.example.useaapp.R;

import java.util.List;

public class Adapter_guest_program_faculty_asso extends RecyclerView.Adapter<Adapter_guest_program_faculty_asso.ViewHolder> {
    List<Response_model_guest_program_faculty_asso> data;
    public Adapter_guest_program_faculty_asso(List<Response_model_guest_program_faculty_asso> data) {
        this.data = data;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_item_guest_program, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.Guest_program_major.setText(data.get(position).getMajor_name());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        TextView Guest_program_major;

        public ViewHolder(@NonNull View itemView){
            super(itemView);
            Guest_program_major = itemView.findViewById(R.id.Guest_program_major);
        }
    }
}
