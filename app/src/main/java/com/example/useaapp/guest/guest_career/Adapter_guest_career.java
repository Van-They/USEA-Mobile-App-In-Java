package com.example.useaapp.guest.guest_career;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.useaapp.R;

import java.util.List;

public class Adapter_guest_career extends RecyclerView.Adapter<Adapter_guest_career.ViewHolder> {

    List<com.example.useaapp.guest.guest_career.Response_model_guest_career> data;
    Context context;

    public Adapter_guest_career(List<com.example.useaapp.guest.guest_career.Response_model_guest_career> data, Context context) {
        this.data = data;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_adapter_career, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
         holder.Title_guest_career_item.setText(data.get(position).getJob());
         holder.Detail_guest_career_item.setText(data.get(position).getDepartment());
         holder.Province_guest_career_item.setText(data.get(position).getProvince());
         holder.Month_guest_career_item.setText(data.get(position).getExp_month());
         holder.Date_guest_career_item.setText(data.get(position).getExp_date());
         holder.Year_guest_career_item.setText(data.get(position).getExp_year());

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView Title_guest_career_item, Detail_guest_career_item, Province_guest_career_item,
                Month_guest_career_item, Date_guest_career_item, Year_guest_career_item,
                View_guest_career_detail;

        public ViewHolder(@NonNull View itemView){
            super(itemView);

            Title_guest_career_item = itemView.findViewById(R.id.Title_guest_career_item);
            Detail_guest_career_item = itemView.findViewById(R.id.Detail_guest_career_item);
            Province_guest_career_item = itemView.findViewById(R.id.Province_guest_career_item);
            Month_guest_career_item = itemView.findViewById(R.id.Month_guest_career_item);
            Date_guest_career_item = itemView.findViewById(R.id.Date_guest_career_item);
            Year_guest_career_item = itemView.findViewById(R.id.Year_guest_career_item);
            View_guest_career_detail = itemView.findViewById(R.id.View_guest_career_detail);
            View_guest_career_detail.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            int position = getAdapterPosition();
            Intent intent = new Intent(context, Detail_guest_career.class);
            intent.putExtra("Title_guest_career", data.get(position).getJob());
            intent.putExtra("Detail_guest_career", data.get(position).getDepartment());
            intent.putExtra("Province_guest_career", data.get(position).getProvince());
            intent.putExtra("Month_guest_career", data.get(position).getExp_month());
            intent.putExtra("Date_guest_career", data.get(position).getExp_date());
            intent.putExtra("Year_guest_career", data.get(position).getExp_year());
            intent.putExtra("Label_guest_career", data.get(position).getPosition_avail());
            intent.putExtra("Requirement_detail_guest_career", data.get(position).getRequirement_detail());
            view.getContext().startActivity(intent);
        }
    }
}
