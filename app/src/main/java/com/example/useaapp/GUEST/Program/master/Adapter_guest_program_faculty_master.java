package com.example.useaapp.GUEST.Program.master;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;
import android.widget.Toast;

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
    public static final String [] the = {"1", "2"};
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
                showDialog();
        }

        private void showDialog(){
            final Dialog dialog = new Dialog(itemView.getContext());
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
            dialog.setContentView(R.layout.guest_program_major_bottom_sheet_layout);

            TextView thesis = dialog.findViewById(R.id.thesis);
            TextView non_thesis = dialog.findViewById(R.id.non_thesis);

            thesis.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dialog.dismiss();
                    int position = getAdapterPosition();
                    String txt = data.get(position).getId();
                    String t = "t";
                    Intent intent = new Intent(itemView.getContext(), StudentStudyPlan_Thesis.class);
                    intent.putExtra(t, the[0]);
                    intent.putExtra(text, txt);
                    itemView.getContext().startActivity(intent);
                }
            });

            non_thesis.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dialog.dismiss();
                    int position = getAdapterPosition();
                    String txt = data.get(position).getId();
                    String t = "t";
                    Intent intent = new Intent(itemView.getContext(), StudentStudyPlan_Thesis.class);
                    intent.putExtra(t, the[1]);
                    intent.putExtra(text, txt);
                    itemView.getContext().startActivity(intent);
                }
            });

            dialog.show();
            dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
            dialog.getWindow().setGravity(Gravity.BOTTOM);

        }

    }
}
