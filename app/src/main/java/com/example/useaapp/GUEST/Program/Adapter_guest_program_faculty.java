package com.example.useaapp.GUEST.Program;

import android.content.Context;
import android.content.Intent;
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

public class Adapter_guest_program_faculty extends RecyclerView.Adapter<Adapter_guest_program_faculty.ViewHolder> {
    List<Response_model_guest_program_faculty> data;
    Context context;
    public static final String text = "txt";

    public Adapter_guest_program_faculty(List<Response_model_guest_program_faculty> data, Context context) {
        this.data = data;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_guest_program_faculty, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.guest_program_faculty.setText(data.get(position).getFaculty_name());
        Glide.with(holder.guest_program_faculty.getContext()).load("http://192.168.0.170/USEA/Guest/faculty_icon/" + data.get(position).getIcon()).into(holder.guest_program_faculty_icon);

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView guest_program_faculty;
        ImageView guest_program_faculty_icon;

        public ViewHolder(@NonNull View itemView){
            super(itemView);
            guest_program_faculty = itemView.findViewById(R.id.guest_program_faculty);
            guest_program_faculty_icon = itemView.findViewById(R.id.guest_program_faculty_icon);
            guest_program_faculty.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            int position = getAdapterPosition();
            String txt = data.get(position).getId();
            if(txt.equals("1")){
                Intent intent = new Intent(view.getContext(), GuestDetailProgram.class);
                intent.putExtra(text, txt);
                view.getContext().startActivity(intent);
            }else if(txt.equals("2")){
                Intent intent = new Intent(view.getContext(), GuestDetailProgram.class);
                intent.putExtra(text, txt);
                view.getContext().startActivity(intent);
            }else if(txt.equals("3")){
                Intent intent = new Intent(view.getContext(), GuestDetailProgram.class);
                intent.putExtra(text, txt);
                view.getContext().startActivity(intent);
            }else if(txt.equals("4")){
                Intent intent = new Intent(view.getContext(), GuestDetailProgram.class);
                intent.putExtra(text, txt);
                view.getContext().startActivity(intent);
            }
        }
    }
}
