package com.example.healthmonitor;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

public class BloggerAPI
{
    private static final String url="https://www.ecssofttech.com/api/";
    private static final String key="gym";

    public static PostService postService=null;

    public static PostService getServices()

    {

        if (postService == null) {

            Gson gson = new GsonBuilder()
                    .setLenient()
                    .create();

            Retrofit retrofit=new Retrofit.Builder().baseUrl(url).addConverterFactory(GsonConverterFactory.create()).build();
            postService=retrofit.create(PostService.class);
        }

        return postService;

    }

    public interface PostService
    {
        @GET("login.php")
        Call<List<ModelClass>> getModelList(
                @Query("username") String username,
                @Query("password") String password
        );
    }

    /*
    public interface ImageList
    {
        @GET("downloadfile/{image}")
        Call<ItemsImagesList> getImageList(@Path("image") String image);
    }

     */
}
