package com.satyam.newswala;

import android.content.Context;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.satyam.newswala.adapters.CenterZoomLayoutManager;
import com.satyam.newswala.adapters.NewAdapter;
import com.satyam.newswala.adapters.SearchedAdapter;
import com.satyam.newswala.adapters.adapter;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Retrofit {

    ArrayList<String> one, link, web, content, description, publisher;


    public void getData(final RecyclerView recyclerView, String string, final Context context) {



        LinearLayoutManager layoutManager = new LinearLayoutManager(context,
                LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);

        final Call<PostList> postlist = NewsApi.getPostService().getPostList(string);
        postlist.enqueue(new Callback<PostList>() {
            @Override
            public void onResponse(@NotNull Call<PostList> call, @NotNull Response<PostList> response) {

                one = new ArrayList<>();
                link = new ArrayList<>();
                web = new ArrayList<>();
                content = new ArrayList<>();
                description = new ArrayList<>();
                publisher = new ArrayList<>();


                PostList list = response.body();
                for (int i = 0; i < list.getArticles().size(); i++) {
                    Article article = list.getArticles().get(i);
                    one.add(article.getTitle());
                    link.add(article.getUrlToImage());
                    web.add(article.getUrl());
                    content.add(article.getContent());
                    description.add(article.getDescription());
                    publisher.add(article.getAuthor());

                }
                adapter a = new adapter(context, link, one, web, content, description, publisher);

                    recyclerView.setAdapter(a);

            }

            @Override
            public void onFailure(@NotNull Call<PostList> call, @NotNull Throwable t) {

                Toast.makeText(context, "error", Toast.LENGTH_LONG).show();
            }
        });

    }


    public void getNewData(final RecyclerView recyclerView, String string, final Context context) {

        CenterZoomLayoutManager centerZoomLayoutManager =
                new CenterZoomLayoutManager(context,LinearLayoutManager.HORIZONTAL,false);



        recyclerView.setLayoutManager(centerZoomLayoutManager);

        final Call<PostList> postlist = NewsApi.getPostService().getPostList(string);
        postlist.enqueue(new Callback<PostList>() {
            @Override
            public void onResponse(@NotNull Call<PostList> call, @NotNull Response<PostList> response) {

                one = new ArrayList<>();
                link = new ArrayList<>();
                web = new ArrayList<>();
                content = new ArrayList<>();
                description = new ArrayList<>();
                publisher = new ArrayList<>();


                PostList list = response.body();
                for (int i = 0; i < list.getArticles().size(); i++) {
                    Article article = list.getArticles().get(i);
                    one.add(article.getTitle());
                    link.add(article.getUrlToImage());
                    web.add(article.getUrl());
                    content.add(article.getContent());
                    description.add(article.getDescription());
                    publisher.add(article.getAuthor());

                }
                NewAdapter a = new NewAdapter(context, link, one, web, content, description, publisher);

                recyclerView.setAdapter(a);

            }

            @Override
            public void onFailure(@NotNull Call<PostList> call, @NotNull Throwable t) {

                Toast.makeText(context, "error", Toast.LENGTH_LONG).show();
            }
        });

    }

    public void getNeData(final RecyclerView recyclerView, String string, final Context context) {

        LinearLayoutManager layoutManager = new LinearLayoutManager(context,
                LinearLayoutManager.VERTICAL, false);


        recyclerView.setLayoutManager(layoutManager);

        final Call<PostList> postlist = NewsApi.getPostService().getPostList(string);
        postlist.enqueue(new Callback<PostList>() {
            @Override
            public void onResponse(@NotNull Call<PostList> call, @NotNull Response<PostList> response) {

                one = new ArrayList<>();
                link = new ArrayList<>();
                web = new ArrayList<>();
                content = new ArrayList<>();
                description = new ArrayList<>();
                publisher = new ArrayList<>();


                PostList list = response.body();
                for (int i = 0; i < list.getArticles().size(); i++) {
                    Article article = list.getArticles().get(i);
                    one.add(article.getTitle());
                    link.add(article.getUrlToImage());
                    web.add(article.getUrl());
                    content.add(article.getContent());
                    description.add(article.getDescription());
                    publisher.add(article.getAuthor());

                }
                SearchedAdapter a = new SearchedAdapter(context, link, one, web, content, description, publisher);

                recyclerView.setAdapter(a);

            }

            @Override
            public void onFailure(@NotNull Call<PostList> call, @NotNull Throwable t) {

                Toast.makeText(context, "error", Toast.LENGTH_LONG).show();
            }
        });

    }
}
