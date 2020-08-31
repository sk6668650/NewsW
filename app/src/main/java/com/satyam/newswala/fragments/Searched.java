package com.satyam.newswala.fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.satyam.newswala.apiKey.News;
import com.satyam.newswala.R;
import com.satyam.newswala.adapters.SearchedAdapter;
import com.satyam.newswala.data.NewData;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


public class Searched extends Fragment {
    RequestQueue requestQueue;
    RecyclerView recyclerView;
    ArrayList<String> one,link,web,content,description,publisher;


    View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view =  inflater.inflate(R.layout.fragment_searched, container, false);
        assert getArguments() != null;
        final String query = getArguments().getString("Search");

        getActivity().setTitle("Searched");
        recyclerView = view.findViewById(R.id.recyclerView);

        requestQueue = Volley.newRequestQueue(getContext());

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET,
                News.CATEGORY+query+News.API_KEY, null,
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
                        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(),
                                LinearLayoutManager.VERTICAL,false);
                        SearchedAdapter a = new SearchedAdapter(getContext(),link,one,web,content,description,publisher);
                        if(a.getItemCount() == 0)
                        {
                            Toast.makeText(getContext(), "empty", Toast.LENGTH_SHORT).show();
                        }
                        else {

                            recyclerView.setAdapter(a);
                            recyclerView.setLayoutManager(layoutManager);
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



        return view;

    }


}