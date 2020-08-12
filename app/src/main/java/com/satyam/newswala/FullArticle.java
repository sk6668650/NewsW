package com.satyam.newswala;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.android.material.bottomsheet.BottomSheetBehavior;

public class FullArticle extends AppCompatActivity
{
    BottomSheetBehavior bottomSheetBehavior;
    LinearLayout linearLayout;
    ImageView imageView;
    TextView textView,textView2,textView3;
    WebView webView;
    View v;
    String data1,data2,data3,data4,data5,data6;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_article);
        imageView = findViewById(R.id.image1);
        textView  = findViewById(R.id.title1);
        textView2 = findViewById(R.id.content1);
        textView3 = findViewById(R.id.textPub);
        webView   = findViewById(R.id.webview);
        linearLayout = findViewById(R.id.publisherlay);
        v = findViewById(R.id.linee);
        View BottomSheet = findViewById(R.id.bottom_sheet);

        getData();
        setData();
        bottomSheetBehavior = BottomSheetBehavior.from(BottomSheet);

        bottomSheetBehavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View view, int i) {

                switch (i)
                {
                    case BottomSheetBehavior.STATE_EXPANDED:
                        imageView.setVisibility(View.GONE);
                        textView.setVisibility(View.GONE);
                        textView2.setVisibility(View.GONE);
                        linearLayout.setVisibility(View.GONE);
                        textView3.setVisibility(View.GONE);
                        v.setVisibility(View.GONE);
                        view = FullArticle.this.getWindow().getDecorView();
                        view.setBackgroundResource(R.color.white);
                        break;
                    case BottomSheetBehavior.STATE_DRAGGING:
                        view = FullArticle.this.getWindow().getDecorView();
                        //view.setBackgroundResource(R.color.colorPrimaryDark);
                        break;
                    case BottomSheetBehavior.STATE_COLLAPSED:
                        imageView.setVisibility(View.VISIBLE);
                        textView.setVisibility(View.VISIBLE);
                        linearLayout.setVisibility(View.VISIBLE);
                        textView2.setVisibility(View.VISIBLE);
                        textView3.setVisibility(View.VISIBLE);
                        v.setVisibility(View.VISIBLE);
                        break;


                }

            }

            @Override
            public void onSlide(@NonNull View view, float v) {

            }
        });
    }
    public void  getData()
    {
        if(getIntent().hasExtra("key1")
                && getIntent().hasExtra("key2")
                && getIntent().hasExtra("key3") && getIntent().hasExtra("key4") && getIntent().hasExtra("key5") && getIntent().hasExtra("key6"))
        {
            data1 = getIntent().getStringExtra("key1");
            data2 = getIntent().getStringExtra("key2");
            data3 = getIntent().getStringExtra("key3");
            data4 = getIntent().getStringExtra("key4");
            data5 = getIntent().getStringExtra("key5");
            data6 = getIntent().getStringExtra("key6");


        }
        else
            {

            Toast.makeText(this, "no result found.", Toast.LENGTH_SHORT).show();

            }


    }
    public  void setData()
    {
        Glide.with(FullArticle.this)
                .load(data2)
                .into(imageView);
        textView.setText(data1);
        textView3.setText(data6);

        String one=data4 ,two=data5;
        int up=0,upp=0;
        for(int i =0 ;i <one.length();i++)
        {
           char ch =one.charAt(i);
            if (ch >= 0 && ch <= 255)
                up++;
        }
        for(int j =0;j<two.length();j++)
        {
            char ch2 =two.charAt(j);
            if(ch2 >=0 && ch2<=255)
                upp++;
        }

        if(up>upp)
        {
            textView2.setText(data4);
        }
        else
        {
            textView2.setText(data5);
        }


/*
        if(!data4.equals("null"))
        {
            textView2.setText(data4);
        }
        else {
            textView2.setText(data5);
        }

 */

        /*
        WebSettings wset = webView.getSettings();
        wset.setJavaScriptEnabled(true);
        wset.setDomStorageEnabled(true);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl(data3);
        */


        webView.getSettings().setDomStorageEnabled(true);
        webView.getSettings().setJavaScriptEnabled(true);
       // WebSettingsCompat.setForceDark(webView.getSettings(),WebSettingsCompat.FORCE_DARK_ON);
        webView.getSettings().setLoadsImagesAutomatically(true);
       // webView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl(data3);



    }
}
