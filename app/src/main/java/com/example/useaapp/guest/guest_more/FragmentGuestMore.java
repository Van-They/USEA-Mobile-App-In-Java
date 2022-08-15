package com.example.useaapp.guest.guest_more;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.useaapp.R;
public class FragmentGuestMore extends Fragment {
    ImageButton btn_fb, btn_ig, btn_yt, btn_tele, btn_web;
    private ImageButton Btn_fb, Btn_ig, Btn_yt, Btn_tele, Btn_web, img_location;
    private TextView  txt_location_txt;
    //Link to URL
    private void gotUrl(String s) {
        Uri uri = Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW,uri));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_guest_more, container, false);
        //Assign ImageButton Variable
        Btn_fb = view.findViewById(R.id.btn_fb);
        Btn_ig = view.findViewById(R.id.btn_ig);
        Btn_yt = view.findViewById(R.id.btn_yt);
        Btn_tele = view.findViewById(R.id.btn_tele);
        Btn_web = view.findViewById(R.id.btn_web);
        img_location = view.findViewById(R.id.img_location);

        txt_location_txt = view.findViewById(R.id.txt_location_txt);
        //Social Media
        //Click FB Image
        Btn_fb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotUrl("https://facebook.com/usea.edu.kh");
            }
        });
        //Click IG Image
        Btn_ig.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotUrl("https://www.instagram.com/university_of_south_east_asia/");
            }
        });
        //Click Telegram Image
        Btn_tele.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotUrl("https://facebook.com/usea.edu.kh");
            }
        });
        //Click Youtube Image
        Btn_yt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotUrl("https://www.youtube.com/channel/UCj_1fYGP6NXxYWcRkqbvN6A");
            }
        });
        //Click Youtube Image
        Btn_web.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotUrl("https://usea.edu.kh/en/index.php");
            }
        });
        //Click Location Text
        txt_location_txt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotUrl("https://www.google.com/maps/dir/13.3551786,103.8564198/13.3503099,103.8641453/@13.3527153,103.8556504,16z/data=!3m1!4b1!4m4!4m3!1m1!4e1!1m0");
            }
        });
        //Click on Location Image
        img_location.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotUrl("https://www.google.com/maps/dir/13.3551786,103.8564198/13.3503099,103.8641453/@13.3527153,103.8556504,16z/data=!3m1!4b1!4m4!4m3!1m1!4e1!1m0");
            }
        });
        return view;
    }
}