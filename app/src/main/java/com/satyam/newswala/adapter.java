package com.satyam.newswala;


import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class adapter extends RecyclerView.Adapter<adapter.MyViewHolder>
{
  ArrayList image;
  ArrayList title;
  ArrayList cont;
  ArrayList url;
  ArrayList des;
  ArrayList pub;
  Context   context;


  public adapter(Context c, ArrayList link, ArrayList one,ArrayList url1,ArrayList contt,ArrayList dess,ArrayList publisher) {

    
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
    View view = layoutInflater.inflate(R.layout.news,parent,false);

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



    if(image.get(position)==null | des.get(position)==null | cont.get(position)==null)
    {
      holder.cardView.setVisibility(View.GONE);
      holder.imageView.setVisibility(View.GONE);
      holder.textView.setText(View.GONE);
      holder.textView2.setVisibility(View.GONE);
    }

      holder.textView.setText(ooo);
      holder.textView2.setText(ooo5);
      Glide.with(context)
              .load(ooo1)
              .into(holder.imageView);


    holder.frameLayout.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v)
      {
        Intent i = new Intent(context,FullArticle.class);
        i.putExtra("key1",ooo);
        i.putExtra("key2",ooo1);
        i.putExtra("key3",ooo2);
        i.putExtra("key4",ooo3);
        i.putExtra("key5",ooo4);
        i.putExtra("key6",ooo5);

        context.startActivity(i);


      }
    });
  }

  @Override
  public int getItemCount()
  {
    return image.size();
  }


  public class MyViewHolder extends RecyclerView.ViewHolder
  {
    TextView textView,textView2;
    ImageView imageView;
    CardView cardView;
    LinearLayout frameLayout;


    public MyViewHolder(@NonNull View itemView)
    {
      super(itemView);
      textView2 = itemView.findViewById(R.id.publisher);
      textView = itemView.findViewById(R.id.title);

      frameLayout = itemView.findViewById(R.id.root);
      cardView   = itemView.findViewById(R.id.cardNews);
      imageView = itemView.findViewById(R.id.imageView);
    }
  }
}
