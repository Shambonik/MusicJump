package com.unity3d.player.retrofit;


import android.util.JsonReader;
import com.google.gson.GsonBuilder;
import com.google.gson.Gson;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    private static RetrofitClient client;
    private static final String baseURL = "http://192.168.0.103:8090";
    private Retrofit retrofit;

    private RetrofitClient(){
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        retrofit = new Retrofit.Builder()
                .baseUrl(baseURL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
    }

    public static RetrofitClient getInstance(){
        if (client == null){
            client = new RetrofitClient();
        }
        return client;
    }

    public ApiService getApi(){
        return retrofit.create(ApiService.class);
    }
}
