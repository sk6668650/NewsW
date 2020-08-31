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
import android.widget.LinearLayout;
import android.widget.Toast;

import com.satyam.newswala.R;

public class Account extends Fragment implements View.OnClickListener {
    View view;
    LinearLayout layout1,layout2,layout3,layout4;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_account, container, false);
        layout1 = view.findViewById(R.id.linear1);
        layout2 = view.findViewById(R.id.linear2);
        layout3 = view.findViewById(R.id.linear3);
        layout4 = view.findViewById(R.id.linear4);
        getActivity().setTitle("Account");
        layout1.setOnClickListener(this);
        layout2.setOnClickListener(this);
        layout3.setOnClickListener(this);
        layout4.setOnClickListener(this);
        Bundle bundle = new Bundle();
        bundle.putInt("newKey",4);



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
            Log.i("Finished sending email...", "");
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(getContext(), "There is no email client installed.", Toast.LENGTH_SHORT).show();
        }
    }
}