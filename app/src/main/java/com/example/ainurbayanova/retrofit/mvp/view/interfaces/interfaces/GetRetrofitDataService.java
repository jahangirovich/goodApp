package com.example.ainurbayanova.retrofit.mvp.view.interfaces.interfaces;

import com.example.ainurbayanova.retrofit.mvp.model.FilmsModel;
import com.example.ainurbayanova.retrofit.mvp.model.Login;
import com.example.ainurbayanova.retrofit.mvp.model.PeopleModel;
import com.example.ainurbayanova.retrofit.mvp.model.ResultModel;
import com.example.ainurbayanova.retrofit.mvp.model.User;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface GetRetrofitDataService {
    @POST("connect")
    Call<User> login(@Body Login login);
}
