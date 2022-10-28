package com.example.useaapp.GUEST.Program.master;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.useaapp.GUEST.Program.bachelor.Response_model_guest_program_faculty_bachelor;
import com.example.useaapp.R;
import com.example.useaapp.STUDENT.StudyPlan.StudentStudyPlan;
import com.example.useaapp.STUDENT.StudyPlan.StudentStudyPlan_Thesis;

import java.util.List;

public class Adapter_guest_program_faculty_master extends RecyclerView.Adapter<Adapter_guest_program_faculty_master.ViewHolder> {
    List<Response_model_guest_program_faculty_master> data;
    public static final String text = "txt";
    Context context;

    public Adapter_guest_program_faculty_master(List<Response_model_guest_program_faculty_master> data, Context context) {
        this.data = data;
        this.context = context;
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

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView Guest_program_major;
        public ViewHolder(@NonNull View itemView){
            super(itemView);
            Guest_program_major = itemView.findViewById(R.id.Guest_program_major);
            Guest_program_major.setOnClickListener(this);

        }
        public void onClick(View view){
            int position = getAdapterPosition();
            String txt = data.get(position).getId();
            if(txt.equals("19")){
                Intent intent = new Intent(view.getContext(), StudentStudyPlan_Thesis.class);
                intent.putExtra(text, txt);
                view.getContext().startActivity(intent);
            }


        }
    }
}
