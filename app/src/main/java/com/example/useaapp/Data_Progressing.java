package com.example.useaapp;

import android.app.AlertDialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;

public class Data_Progressing extends AlertDialog {
    AlertDialog alert;
    AlertDialog.Builder builder;
    public Data_Progressing(Context context) {
        super(context);
        View layout = LayoutInflater.from(context).inflate(R.layout.custom_loading_data,null);
        builder = new Builder(getContext());
        builder.setCancelable(false);
        builder.setView(layout);
        alert = builder.create();
        alert.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        alert.show();
    }
    public void stopDialog(){
        alert.dismiss();
    }
}
