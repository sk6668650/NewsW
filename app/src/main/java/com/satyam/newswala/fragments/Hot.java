package com.satyam.newswala.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.satyam.newswala.Retrofit;
import com.satyam.newswala.apiKey.News;
import com.satyam.newswala.R;
import com.satyam.newswala.adapters.adapter;
import com.satyam.newswala.data.NewData;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Hot extends Fragment {
    RecyclerView recyclerView;

    View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_india, container, false);
        getActivity().setTitle("Hot");
        Bundle bundle = new Bundle();
        bundle.putInt("newKey",3);
        recyclerView = view.findViewById(R.id.recyclerView);

        Retrofit retrofit = new Retrofit();
        retrofit.getData(recyclerView,News.HOT,requireActivity());


        return view;
    }
}