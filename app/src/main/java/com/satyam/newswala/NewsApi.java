package com.satyam.newswala;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Url;

public class NewsApi {


    private static final String key = "http://newsapi.org/v2/";
    private static final String url = "523ed99ebfd74e6bbbcca29b713c1383";

    public static postService postService=null;
    public static postService getPostService()
    {

        if(postService==null){

            Retrofit retrofit = new Retrofit.Builder().baseUrl(key)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            postService = retrofit.create(postService.class);
        }
        return postService;

    }

    public interface postService {


        @GET()
        Call<com.satyam.newswala.PostList> getPostList(@Url String link);

    }


}
