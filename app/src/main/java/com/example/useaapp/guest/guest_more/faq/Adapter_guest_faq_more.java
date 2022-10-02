package com.example.useaapp.guest.guest_more.faq;

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
import com.example.useaapp.guest.guest_registration.Response_model_guest_registration;

import java.util.List;

public class Adapter_guest_faq_more extends RecyclerView.Adapter<Adapter_guest_faq_more.ViewHolder> {
    List<Response_model_guest_faq_more> data;
    public Adapter_guest_faq_more(List<Response_model_guest_faq_more> data) {
        this.data = data;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_guest_faq_more, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.guest_faq_more_question.setText(data.get(position).getFaq_que());
        holder.guest_faq_more_answer.setText(data.get(position).getFaq_ans());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        CardView guest_faq_more_cardview;
        LinearLayout guest_faq_more_layout;
        TextView guest_faq_more_question, guest_faq_more_answer;

        public ViewHolder(@NonNull View itemView){
            super(itemView);
            guest_faq_more_question = itemView.findViewById(R.id.guest_faq_more_question);
            guest_faq_more_answer = itemView.findViewById(R.id.guest_faq_more_answer);
            guest_faq_more_layout = itemView.findViewById(R.id.guest_faq_more_layout);
            guest_faq_more_layout.getLayoutTransition().enableTransitionType(LayoutTransition.CHANGING);

            guest_faq_more_cardview = itemView.findViewById(R.id.guest_faq_more_cardview);
            guest_faq_more_cardview.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int view_ass = (guest_faq_more_answer.getVisibility() == View.GONE)? View.VISIBLE: View.GONE;
                    TransitionManager.beginDelayedTransition(guest_faq_more_layout, new AutoTransition());
                    guest_faq_more_answer.setVisibility(view_ass);
                }
            });
        }
    }
}
