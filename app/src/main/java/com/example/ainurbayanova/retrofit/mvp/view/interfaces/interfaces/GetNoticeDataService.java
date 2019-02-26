package com.example.ainurbayanova.retrofit.mvp.view.interfaces.interfaces;

import com.example.ainurbayanova.retrofit.mvp.model.Categories;
import com.example.ainurbayanova.retrofit.mvp.model.FilmsModel;
import com.example.ainurbayanova.retrofit.mvp.model.MainCategory;
import com.example.ainurbayanova.retrofit.mvp.model.PeopleModel;
import com.example.ainurbayanova.retrofit.mvp.model.ResultModel;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface GetNoticeDataService {

    @Headers("Authorization: Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJVc2VySWQiOjJ9.sl7UdPt9qsVEQBXBd_FnWft8qGMUK0wXpdWPvcyJTnU")
    @GET("api/categories")
    Call<MainCategory> getPeopleModel();

    @Headers("Authorization: Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJVc2VySWQiOjJ9.sl7UdPt9qsVEQBXBd_FnWft8qGMUK0wXpdWPvcyJTnU")
    @GET("api/categories")
    Call<Response<ResponseBody>> getCategories();

    @GET("people/{id}")
    Call<ResultModel> getPeopleDetailMode(@Path("id") int id);

    @GET("people")
    Call<PeopleModel> getPaggingData(@Query("page") int pageIndex);

    @GET("films/{id}")
    Call<FilmsModel> getFilms(@Path("id") int id);
}
