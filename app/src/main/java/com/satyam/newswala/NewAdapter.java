package com.satyam.newswala;


import android.content.Context;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.Resource;

import java.util.ArrayList;



public class NewAdapter extends RecyclerView.Adapter<NewAdapter.MyViewHolder>
{
    ArrayList image;
    ArrayList title;
    ArrayList cont;
    ArrayList url;
    ArrayList des;
    ArrayList pub;
    Context   context;


    public NewAdapter(Context c, ArrayList link, ArrayList one,ArrayList url1,ArrayList contt,ArrayList dess,ArrayList publisher) {


        context = c;
        image   = link;
        title   = one;
        cont    = contt;
        url     = url1;
        des     = dess;
        pub     = publisher;


    }

    @NonNull
    @Override

    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.cat_news,parent,false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position)
    {
        final String ooo =  (String)  title.get(position);
        final String ooo1 = (String)  image.get(position);
        final String ooo2 = (String)  url.get(position);
        final String ooo3 = (String)  cont.get(position);
        final String ooo4 = (String)  des.get(position);

        final String ooo5 = (String)  pub.get(position);


        String pub = "   "+ooo5;
        holder.textView1.setText(ooo);
        holder.textView.setText(pub);
        //holder.textView2.setText(ooo4);
        Glide.with(context)
                .load(ooo1)
                .into(holder.imageView);



         String one=ooo3 ,two=ooo4;
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
            holder.textView2.setText(ooo3);
        }
        else
        {
            holder.textView2.setText(ooo4);
        }





    }

    @Override
    public int getItemCount()
    {
        return image.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder
    {
        TextView textView,textView1,textView2;
        ImageView imageView;


        public MyViewHolder(@NonNull View itemView)
        {
            super(itemView);
            textView = itemView.findViewById(R.id.catPub);
            textView1 = itemView.findViewById(R.id.catnew);
            textView2 = itemView.findViewById(R.id.catDes);
            imageView = itemView.findViewById(R.id.categoryImage);
        }
    }
}
