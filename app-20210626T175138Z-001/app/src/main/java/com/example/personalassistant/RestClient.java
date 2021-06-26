package com.example.personalassistant;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RestClient {

    public static RestClient retrofitRestClient = null;
    public static ServicesAPI apiServices = null;

    String Baseurl="http://pa.upscalelearninginstitute.com/api/";
    public RestClient()
    {

        Gson gson = new GsonBuilder().setLenient().create();

        final OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .readTimeout(60, TimeUnit.SECONDS)
                .connectTimeout(60, TimeUnit.SECONDS)
                .build();

        Retrofit retrofit = new Retrofit.Builder().client(okHttpClient).addConverterFactory(GsonConverterFactory.create(gson)).baseUrl(Baseurl).build();

        apiServices = retrofit.create(ServicesAPI.class);
    }

    public static RestClient getInstance()
    {
        if (retrofitRestClient == null)
        {
            retrofitRestClient = new RestClient();
        }
        return retrofitRestClient;
    }

    public ServicesAPI getApiServices()
    {
        return apiServices;
    }
}
