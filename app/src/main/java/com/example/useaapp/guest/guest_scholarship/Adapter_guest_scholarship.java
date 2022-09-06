package com.example.useaapp.guest.guest_scholarship;

import android.content.Context;
import android.content.Intent;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.useaapp.R;
import com.example.useaapp.guest.guest_scholarship.ScholarshipItemsDetail;
import com.example.useaapp.guest.guest_scholarship.ScholarshipModel;

import java.util.ArrayList;

public class Adapter_guest_scholarship extends ArrayAdapter<ScholarshipModel> {

    private final static String
            Title = "Title",
            Degree = "Degree",
            Fee = "Fee",
            Date = "Date",
            Month = "Month",
            Year = "Year";

    public Adapter_guest_scholarship(@NonNull Context context, ArrayList<ScholarshipModel> arrayList) {
        super(context, R.layout.custom_items_guest_scholarship, arrayList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_items_guest_scholarship, parent, false);
        }
        ScholarshipModel Data = getItem(position);
        TextView Title_guest_scholarship,
                Degree_guest_scholarship,
                Fee_guest_scholarship,
                Date_guest_scholarship,
                Month_guest_scholarship,
                Year_guest_scholarship;
        Button ReadDetail;

        Title_guest_scholarship = convertView.findViewById(R.id.Title_guest_scholarship);
        Degree_guest_scholarship = convertView.findViewById(R.id.Degree_guest_scholarship);
        Fee_guest_scholarship = convertView.findViewById(R.id.Fee_guest_scholarship);
        Date_guest_scholarship = convertView.findViewById(R.id.Date_guest_scholarship);
        Month_guest_scholarship = convertView.findViewById(R.id.Month_guest_scholarship);
        Year_guest_scholarship = convertView.findViewById(R.id.Year_guest_scholarship);
        ReadDetail = convertView.findViewById(R.id.ReadMore_guest_scholarship);


        Title_guest_scholarship.setText(Data.getTitle());
        Degree_guest_scholarship.setText(Data.getDegree());
        Fee_guest_scholarship.setText(Data.getFee());
        Date_guest_scholarship.setText(Html.fromHtml(Data.getDate()));
        Month_guest_scholarship.setText(Data.getMonth());
        Year_guest_scholarship.setText(Data.getYear());

        ReadDetail.setOnClickListener(v -> {
            Toast.makeText(getContext(), Data.getTitle(), Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(getContext(), ScholarshipItemsDetail.class);
            intent.putExtra(Title, Data.getTitle());
            intent.putExtra(Degree, Data.getDegree());
            intent.putExtra(Fee, Data.getFee());
            intent.putExtra(Date, Data.getDate());
            intent.putExtra(Month, Data.getMonth());
            intent.putExtra(Year, Data.getYear());
            v.getContext().startActivity(intent);
        });

        return convertView;
    }
}
