package com.example.ainurbayanova.retrofit.mvp.presenter;

import android.util.Log;

import com.example.ainurbayanova.retrofit.mvp.model.PeopleModel;
import com.example.ainurbayanova.retrofit.mvp.model.ResultModel;
import com.example.ainurbayanova.retrofit.mvp.network.RetrofitInstance;
import com.example.ainurbayanova.retrofit.mvp.view.interfaces.interfaces.GetNoticeDataService;
import com.example.ainurbayanova.retrofit.mvp.view.interfaces.interfaces.MainPeopleInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class GetNoticePresenter implements MainPeopleInterface.getNoticeIntractor {

    @Override
    public void getNoticeArrayList(final OnFinishedListener listener) {
        final GetNoticeDataService getNoticeDataService = RetrofitInstance.getApiService();

//        Call<PeopleModel> call = getNoticeDataService.getPeopleModel();
//
//        call.enqueue(new Callback<PeopleModel>() {
//            @Override
//            public void onResponse(Call<PeopleModel> call, Response<PeopleModel> response) {
//                listener.onFinished(response.body().getResults(),response.body());
//            }
//
//            @Override
//            public void onFailure(Call<PeopleModel> call, Throwable t) {
//
//            }
//        });


    }
}
