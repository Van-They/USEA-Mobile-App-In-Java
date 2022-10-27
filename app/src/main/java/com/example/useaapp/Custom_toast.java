package com.example.useaapp;

import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class Custom_toast extends Toast {
    Toast toast;
    TextView text_toast;
    Context mContext;

    public Custom_toast(Context context) {
        super(context);
        this.mContext = context;
    }

    public void showToast(String msg) {
        toast = new Toast(mContext);
        View view = LayoutInflater.from(mContext).inflate(R.layout.custom_toast, null);
        text_toast = view.findViewById(R.id.text_custom_toast);
        text_toast.setText(msg);
        toast.setView(view);
        toast.setGravity(Gravity.BOTTOM | Gravity.CENTER,0,50);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.show();
    }
}
