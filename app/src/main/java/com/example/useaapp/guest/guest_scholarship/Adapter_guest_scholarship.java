package com.example.useaapp.guest.guest_scholarship;

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

public class Adapter_guest_scholarship extends RecyclerView.Adapter<Adapter_guest_scholarship.ViewHolder> {

    List<Response_model_guest_scholarship> data;
    Context context;

    public Adapter_guest_scholarship(List<Response_model_guest_scholarship> data, Context context) {
        this.data = data;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_adapter_scholarship, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.Subject_guest_scholarship.setText(data.get(position).getSubject());
         holder.University_guest_scholarship.setText(data.get(position).getUniversity());
         holder.Degree_guest_scholarship.setText(data.get(position).getDegree());
         holder.Fee_guest_scholarship.setText(data.get(position).getCost());
         holder.Date_guest_scholarship.setText(data.get(position).getDate());
         holder.Month_guest_scholarship.setText(data.get(position).getMonth());
         holder.Year_guest_scholarship.setText(data.get(position).getYear());

         holder.ReadMore_guest_scholarship.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Intent intent = new Intent(context, Detail_guest_scholarship.class);
                 intent.putExtra("University_guest_scholarship", data.get(position).getUsea_name());
                 intent.putExtra("Detail_description_guest_scholarship", data.get(position).getDetail_description());
                 intent.putExtra("Date_open_detail_guest_scholarship", data.get(position).getApp_open_date());
                 intent.putExtra("Date_close_detail_guest_scholarship", data.get(position).getApp_open_final_day_date());
                 intent.putExtra("Learnmore_guest_scholarship", data.get(position).getLearnmore_link());
                 intent.putExtra("Application_required_detail_guest_scholarship", data.get(position).getApp_required());
                 intent.putExtra("How_to_apply_detail_guest_scholarship", data.get(position).getHow_to_apply_link());
                 intent.putExtra("Benefit_type_detail_guest_scholarship", data.get(position).getSingle_pay());
                 intent.putExtra("Full_benefit_detail_guest_scholarship", data.get(position).getFull_ben_detail_link());
                 intent.putExtra("Citizenship_requirement_detail_guest_scholarship", data.get(position).getCitizen_require_detail());
                 intent.putExtra("Total_value_detail_guest_scholarship", data.get(position).getTotal_value_price());
                 intent.putExtra("Application_study_areas_detail_guest_scholarship", data.get(position).getApplicable_study_areas_detail());
                 context.startActivity(intent);
             }
         });

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView Subject_guest_scholarship, University_guest_scholarship, Degree_guest_scholarship,
                Fee_guest_scholarship, Date_guest_scholarship, Month_guest_scholarship, Year_guest_scholarship,
                ReadMore_guest_scholarship;

        public ViewHolder(@NonNull View itemView){
            super(itemView);

            Subject_guest_scholarship = itemView.findViewById(R.id.Subject_guest_scholarship);
            University_guest_scholarship = itemView.findViewById(R.id.University_guest_scholarship);
            Degree_guest_scholarship = itemView.findViewById(R.id.Degree_guest_scholarship);
            Fee_guest_scholarship = itemView.findViewById(R.id.Fee_guest_scholarship);
            Date_guest_scholarship = itemView.findViewById(R.id.Date_guest_scholarship);
            Month_guest_scholarship = itemView.findViewById(R.id.Month_guest_scholarship);
            Year_guest_scholarship = itemView.findViewById(R.id.Year_guest_scholarship);
            ReadMore_guest_scholarship = itemView.findViewById(R.id.ReadMore_guest_scholarship);
        }

    }
}
