package com.example.useaapp.GUEST.Registration;

import android.animation.LayoutTransition;
import android.transition.AutoTransition;
import android.transition.TransitionManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.useaapp.R;

import java.util.List;

public class Adapter_guest_registration extends RecyclerView.Adapter<Adapter_guest_registration.ViewHolder> {
    List<Response_model_guest_registration> data;

    public Adapter_guest_registration(List<Response_model_guest_registration> data) {
        this.data = data;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_guest_registration, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.guest_registration_question.setText(data.get(position).getReg_question());
        holder.guest_registration_answer.setText(data.get(position).getReg_answer());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        CardView guestRegistrationCard;
        LinearLayout guest_registration_layout;
        TextView guest_registration_question, guest_registration_answer;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            guest_registration_question = itemView.findViewById(R.id.guest_registration_question);
            guest_registration_answer = itemView.findViewById(R.id.guest_registration_answer);
            guest_registration_layout = itemView.findViewById(R.id.guest_registration_layout);

            guest_registration_layout.getLayoutTransition().enableTransitionType(LayoutTransition.CHANGING);

            guestRegistrationCard = itemView.findViewById(R.id.guest_registration_cardview);
            guestRegistrationCard.setOnClickListener(view -> {
                int view_ass = (guest_registration_answer.getVisibility() == View.GONE) ? View.VISIBLE : View.GONE;
                TransitionManager.beginDelayedTransition(guest_registration_layout, new AutoTransition());
                guest_registration_answer.setVisibility(view_ass);
            });
        }
    }
}
