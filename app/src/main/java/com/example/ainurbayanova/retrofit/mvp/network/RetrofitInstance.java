package com.example.ainurbayanova.retrofit.mvp.network;

import com.example.ainurbayanova.retrofit.mvp.view.interfaces.interfaces.GetNoticeDataService;
import com.example.ainurbayanova.retrofit.mvp.view.interfaces.interfaces.GetRetrofitDataService;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInstance {
//    private static final String ROOT_URL = "https://swapi.co/api/";
    private static final String ROOT_URL2 = "https://bylem.rocketeer.kz/";

    /**
     * Get Retrofit Instance
     */
    private static Retrofit getRetrofitInstance() {
        return new Retrofit.Builder()
                .baseUrl(ROOT_URL2)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    /**
     * Get API Service
     *
     * @return API Service
     */
    public static GetNoticeDataService getApiService() {
        return getRetrofitInstance().create(GetNoticeDataService.class);
    }

    public static GetRetrofitDataService postApiService(){
        return getRetrofitInstance().create(GetRetrofitDataService.class);
    }
}
