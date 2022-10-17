package com.example.useaapp.GUEST.More.about_us;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.useaapp.R;

import java.util.List;

public class Adapter_guest_about_us_more extends RecyclerView.Adapter<Adapter_guest_about_us_more.ViewHolder> {
    List<Response_model_guest_about_us_more> data;
    public Adapter_guest_about_us_more(List<Response_model_guest_about_us_more> data) {
        this.data = data;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_guest_about_us, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.Guest_about_us_usea_name.setText(data.get(position).getGuest_usea_name());
        holder.Guest_about_us_usea_detail.setText(data.get(position).getGuest_usea_detail());
        Glide.with(holder.Guest_about_us_usea_name.getContext()).load("https://myuseaapp.000webhostapp.com/Guest/usea_logo/" + data.get(position).getGuest_usea_logo()).into(holder.Guest_about_us_usea_logo);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        ImageView Guest_about_us_usea_logo;
        TextView Guest_about_us_usea_name, Guest_about_us_usea_detail;

        public ViewHolder(@NonNull View itemView){
            super(itemView);
            Guest_about_us_usea_logo = itemView.findViewById(R.id.Guest_about_us_usea_logo);
            Guest_about_us_usea_name = itemView.findViewById(R.id.Guest_about_us_usea_name);
            Guest_about_us_usea_detail = itemView.findViewById(R.id.Guest_about_us_usea_detail);
        }
    }
}
