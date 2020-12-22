package com.satyam.newswala.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.satyam.newswala.Retrofit;
import com.satyam.newswala.apiKey.News;
import com.satyam.newswala.R;


public class India extends Fragment {

    RecyclerView recyclerView;


    View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view =  inflater.inflate(R.layout.fragment_india, container, false);

        recyclerView = view.findViewById(R.id.recyclerView);
        Bundle bundle = new Bundle();
        bundle.putInt("newKey",1);
        getActivity().setTitle("India");
        Retrofit retrofit = new Retrofit();
        retrofit.getData(recyclerView,News.INDIA,requireActivity());

        return view;

    }



    }
