package com.example.useaapp.GUEST.More;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.useaapp.GUEST.Login.GuestLogin;
import com.example.useaapp.GUEST.More.about_us.Detail_guest_about_us_more;
import com.example.useaapp.GUEST.More.faq.Detail_guest_faq_more;
import com.example.useaapp.MainActivity;
import com.example.useaapp.databinding.FragmentGuestMoreBinding;
import com.google.firebase.auth.FirebaseAuth;

public class FragmentGuestMore extends Fragment {
    FragmentGuestMoreBinding binding;
    GuestLogin guestLogin;

    //Link to URL
    private void gotUrl(String s) {
        Uri uri = Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW, uri));
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
//        View view = inflater.inflate(R.layout.fragment_guest_more, container, false);
        binding = FragmentGuestMoreBinding.inflate(getLayoutInflater(), container, false);
        guestLogin = new GuestLogin();
        binding.SignOutGuest.setOnClickListener(v -> {
            guestLogin.SignOut();
            requireActivity().finish();
            startActivity(new Intent(getContext(), MainActivity.class));
//            CustomDialogLogOutBinding logout = CustomDialogLogOutBinding.inflate(getLayoutInflater());
//            View view = logout.getRoot();
//            AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
//            builder.setView(view);
//            builder.setCancelable(false);
//            AlertDialog dialog = builder.create();
//            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
//            logout.CancelLogout.setOnClickListener(v1->dialog.dismiss());
//            logout.Logout.setOnClickListener(v2->{
//
//            });
        });
        //Social Media
        //Click FB Image
        binding.btnFb.setOnClickListener(v -> gotUrl("https://facebook.com/usea.edu.kh"));
        //Click IG Image
        binding.btnIg.setOnClickListener(v -> gotUrl("https://www.instagram.com/university_of_south_east_asia/"));
        //Click Telegram Image
        binding.btnTele.setOnClickListener(v -> gotUrl("https://t.me/+H8XxWUFTzaQ5N2Jl"));
        //Click Youtube Image
        binding.btnYt.setOnClickListener(v -> gotUrl("https://www.youtube.com/channel/UCj_1fYGP6NXxYWcRkqbvN6A"));
        //Click Youtube Image
        binding.btnWeb.setOnClickListener(v -> gotUrl("https://usea.edu.kh/en/index.php"));
        //Click Location Text
        binding.txtLocationTxt.setOnClickListener(v -> gotUrl("https://www.google.com/maps/dir/13.3551786,103.8564198/13.3503099,103.8641453/@13.3527153,103.8556504,16z/data=!3m1!4b1!4m4!4m3!1m1!4e1!1m0"));
        //Click on Location Image
        binding.imgLocation.setOnClickListener(v -> gotUrl("https://www.google.com/maps/dir/13.3551786,103.8564198/13.3503099,103.8641453/@13.3527153,103.8556504,16z/data=!3m1!4b1!4m4!4m3!1m1!4e1!1m0"));

        binding.AboutUsDetail.setOnClickListener(v -> startActivity(new Intent(getContext(), Detail_guest_about_us_more.class)));
        binding.FrequentAskQuestion.setOnClickListener(v -> startActivity(new Intent(getContext(), Detail_guest_faq_more.class)));

        return binding.getRoot();
    }
}