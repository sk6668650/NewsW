package com.satyam.newswala;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class CategoryNews extends AppCompatActivity {

    RequestQueue requestQueue;
    RecyclerView recyclerView;
    ArrayList<String> one,link,web,content,description,publisher;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_news);

        showToast();

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.BLACK);
        }
        recyclerView = findViewById(R.id.newRecycler);

        requestQueue = Volley.newRequestQueue(getApplicationContext());

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET,
                News.SPORTS, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response)
                    {
                        one = new ArrayList<>();
                        link = new ArrayList<>();
                        web  = new ArrayList<>();
                        content = new ArrayList<>();
                        description = new ArrayList<>();
                        publisher   = new ArrayList<>();


                        try
                        {
                            JSONArray jsonArray = response.getJSONArray("articles");
                            for(int i = 0;i <  jsonArray.length();i++)
                            {
                                JSONObject jsonObject = jsonArray.getJSONObject(i);
                                one.add(jsonObject.getString("title"));
                                link.add(jsonObject.getString("urlToImage"));
                                web.add(jsonObject.getString("url"));
                                content.add(jsonObject.getString("content"));
                                description.add(jsonObject.getString("description"));


                                JSONObject jsonObject1 = jsonArray.getJSONObject(i);
                                String one = jsonObject1.getString("source");
                                Gson gson = new Gson();
                                NewData newData = gson.fromJson(one,NewData.class);
                                publisher.add(newData.getName());


                            }

                        }


                        catch (JSONException e)
                        {
                            e.printStackTrace();
                        }
                        CenterZoomLayoutManager centerZoomLayoutManager =
                                new CenterZoomLayoutManager(getApplicationContext(),LinearLayoutManager.HORIZONTAL,false);
                         NewAdapter a = new NewAdapter(getApplicationContext(),link,one,web,content,description,publisher);
                        if(a.getItemCount() == 0)
                        {
                            Toast.makeText(getApplicationContext(), "empty", Toast.LENGTH_SHORT).show();
                        }
                        else {
                            recyclerView.setAdapter(a);
                            recyclerView.setLayoutManager(centerZoomLayoutManager);
                        }


                    }
                },


                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error)
                    {
                        Log.d("MyApp","SomeThing Went Wrong");
                    }
                });


        requestQueue.add(jsonObjectRequest);



    }

    public void showToast() {
        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.toast,(ViewGroup) findViewById(R.id.toast));
        Toast toast = new Toast(getApplicationContext());
        toast.setGravity(Gravity.BOTTOM,0,0);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(layout);
        toast.show();
    }
}