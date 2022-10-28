package com.example.useaapp.GUEST.Program.bachelor;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.useaapp.GUEST.Events.announcement.Response_model_guest_event_announcement;
import com.example.useaapp.R;
import com.example.useaapp.STUDENT.StudyPlan.StudentStudyPlan;
import com.example.useaapp.STUDENT.StudyPlan.year1.FragmentStudyPlan_Y1S1S2;
import com.example.useaapp.STUDENT.StudyPlan.year1.Fragment_student_Studyplan_y1s1s2;

import java.util.List;

public class Adapter_guest_program_faculty_bachelor extends RecyclerView.Adapter<Adapter_guest_program_faculty_bachelor.ViewHolder> {
    List<Response_model_guest_program_faculty_bachelor> data;
    public static final String text = "txt";
    Context context;

    public Adapter_guest_program_faculty_bachelor(List<Response_model_guest_program_faculty_bachelor> data, Context context) {
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
            if(txt.equals("12")){
                Intent intent = new Intent(view.getContext(), StudentStudyPlan.class);
                intent.putExtra(text, txt);
                view.getContext().startActivity(intent);
            }else if(txt.equals("13")){
                Intent intent = new Intent(view.getContext(), StudentStudyPlan.class);
                intent.putExtra(text, txt);
                view.getContext().startActivity(intent);
            }else if(txt.equals("14")){
                Intent intent = new Intent(view.getContext(), StudentStudyPlan.class);
                intent.putExtra(text, txt);
                view.getContext().startActivity(intent);
            }else if(txt.equals("15")){
                Intent intent = new Intent(view.getContext(), StudentStudyPlan.class);
                intent.putExtra(text, txt);
                view.getContext().startActivity(intent);
            }else if(txt.equals("16")){
                Intent intent = new Intent(view.getContext(), StudentStudyPlan.class);
                intent.putExtra(text, txt);
                view.getContext().startActivity(intent);
            }else if(txt.equals("17")){
                Intent intent = new Intent(view.getContext(), StudentStudyPlan.class);
                intent.putExtra(text, txt);
                view.getContext().startActivity(intent);
            }


        }
    }
}
