package com.example.useaapp.guest.guest_more;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.useaapp.MainActivity;
import com.example.useaapp.R;
import com.example.useaapp.guest.guest_more.about_us.Detail_guest_about_us_more;
import com.example.useaapp.guest.guest_more.faq.Detail_guest_faq_more;
import com.google.firebase.auth.FirebaseAuth;

public class FragmentGuestMore extends Fragment {
    ImageButton Btn_fb, Btn_ig, Btn_yt, Btn_tele, Btn_web, img_location;
    TextView  txt_location_txt, SignOutGuest;
    LinearLayout About_Us_Detail,Frequent_ask_Question;
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
        SignOutGuest = view.findViewById(R.id.SignOutGuest);
        txt_location_txt = view.findViewById(R.id.txt_location_txt);

        About_Us_Detail = view.findViewById(R.id.About_Us_Detail);
        Frequent_ask_Question = view.findViewById(R.id.Frequent_ask_Question);
        SignOutGuest.setOnClickListener(v->{
            FirebaseAuth.getInstance().signOut();
            startActivity(new Intent(getContext(),MainActivity.class));
        });
        //Social Media
        //Click FB Image
        Btn_fb.setOnClickListener(view1 -> gotUrl("https://facebook.com/usea.edu.kh"));
        //Click IG Image
        Btn_ig.setOnClickListener(view17 -> gotUrl("https://www.instagram.com/university_of_south_east_asia/"));
        //Click Telegram Image
        Btn_tele.setOnClickListener(view12 -> gotUrl("https://facebook.com/usea.edu.kh"));
        //Click Youtube Image
        Btn_yt.setOnClickListener(view13 -> gotUrl("https://www.youtube.com/channel/UCj_1fYGP6NXxYWcRkqbvN6A"));
        //Click Youtube Image
        Btn_web.setOnClickListener(view14 -> gotUrl("https://usea.edu.kh/en/index.php"));
        //Click Location Text
        txt_location_txt.setOnClickListener(view15 -> gotUrl("https://www.google.com/maps/dir/13.3551786,103.8564198/13.3503099,103.8641453/@13.3527153,103.8556504,16z/data=!3m1!4b1!4m4!4m3!1m1!4e1!1m0"));
        //Click on Location Image
        img_location.setOnClickListener(view16 -> gotUrl("https://www.google.com/maps/dir/13.3551786,103.8564198/13.3503099,103.8641453/@13.3527153,103.8556504,16z/data=!3m1!4b1!4m4!4m3!1m1!4e1!1m0"));

        About_Us_Detail.setOnClickListener(this::AboutUsDetail);
        Frequent_ask_Question.setOnClickListener(this::FAQ);

        return view;
    }
    private void AboutUsDetail(View view){
        getContext().startActivity(new Intent(getContext(), Detail_guest_about_us_more.class));
    }
    private void FAQ (View view){
        getContext().startActivity(new Intent(getContext(), Detail_guest_faq_more.class));
    }
}