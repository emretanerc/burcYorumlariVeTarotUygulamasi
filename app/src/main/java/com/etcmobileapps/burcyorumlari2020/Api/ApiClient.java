package com.etcmobileapps.burcyorumlari2020.Api;


import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
    private static Retrofit retrofit=null;

    public static Retrofit getClient() {

        retrofit = new Retrofit.Builder()
                .baseUrl("https://burc-yorumlari.herokuapp.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(new OkHttpClient())
                .build();
        return retrofit;
    }

}

