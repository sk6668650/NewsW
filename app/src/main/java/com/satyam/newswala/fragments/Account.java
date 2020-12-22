package com.satyam.newswala.fragments;

import android.app.Dialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.satyam.newswala.R;

public class Account extends Fragment implements View.OnClickListener {
    View view,view1,view2;
    TextView textView;
    LinearLayout layout1,layout2,layout3,layout4,layout5;
    Animation animation;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_account, container, false);
        layout1 = view.findViewById(R.id.linear1);
        textView = view.findViewById(R.id.animText);
        layout2 = view.findViewById(R.id.linear2);
        view1 = view.findViewById(R.id.slide1);
        view2 = view.findViewById(R.id.slide2);
        layout3 = view.findViewById(R.id.linear3);
        layout4 = view.findViewById(R.id.linear4);
        layout5 = view.findViewById(R.id.login);
        getActivity().setTitle("Account");
        layout1.setOnClickListener(this);
        layout2.setOnClickListener(this);
        layout3.setOnClickListener(this);
        layout4.setOnClickListener(this);
        layout5.setOnClickListener(this);
        Bundle bundle = new Bundle();
        bundle.putInt("newKey",4);

        animation = AnimationUtils.loadAnimation(getContext(),R.anim.fadeout);
        view2.setAnimation(animation);
        view1.setAnimation(animation);
        textView.setAnimation(animation);

        return view;
    }

    @Override
    public void onClick(View v) {

        if(v==layout1)
        {
            About about = new About();
            FragmentManager fm = getFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.setFragment,about);

            ft.addToBackStack("");
            ft.commit();
        }
        else if (v==layout2)
        {

            sendEmail();

        }else if (v==layout3)
        {

            Toast.makeText(getContext(), "This Feature is not Active yet!", Toast.LENGTH_SHORT).show();

        }else if (v==layout4)
        {

            openDialog();
        }else if (v==layout5)
        {
            Toast.makeText(getContext(), "This Feature is not Active yet!", Toast.LENGTH_SHORT).show();

        }

    }

    private void openDialog() {


        final Dialog dialog = new Dialog(getContext());
        dialog.setContentView(R.layout.mylayout);

        dialog.setCanceledOnTouchOutside(true);
        dialog.show();

    }

    protected void sendEmail() {
        Log.i("Send email", "");
        String[] TO = {"sk6668650@gmail.com"};
        String[] CC = {""};
        Intent emailIntent = new Intent(Intent.ACTION_SEND);

        emailIntent.setData(Uri.parse("mailto:"));
        emailIntent.setType("text/plain");
        emailIntent.putExtra(Intent.EXTRA_EMAIL, TO);
        emailIntent.putExtra(Intent.EXTRA_CC, CC);
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "FeedBack");
        emailIntent.putExtra(Intent.EXTRA_TEXT, "");

        try {
            startActivity(Intent.createChooser(emailIntent, "Send mail..."));
            Log.i("myApp", "Finished sending email...");
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(getContext(), "There is no email client installed.", Toast.LENGTH_SHORT).show();
        }
    }
}