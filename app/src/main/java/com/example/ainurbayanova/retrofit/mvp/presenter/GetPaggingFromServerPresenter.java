package com.example.ainurbayanova.retrofit.mvp.presenter;

import com.example.ainurbayanova.retrofit.mvp.model.PeopleModel;
import com.example.ainurbayanova.retrofit.mvp.model.ResultModel;
import com.example.ainurbayanova.retrofit.mvp.network.RetrofitInstance;
import com.example.ainurbayanova.retrofit.mvp.view.interfaces.interfaces.GetNoticeDataService;
import com.example.ainurbayanova.retrofit.mvp.view.interfaces.interfaces.PagginationInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GetPaggingFromServerPresenter implements PagginationInterface.Model {
    @Override
    public void getAllFinished(final OnFinishedListener onFinishedListener, int page) {
        final GetNoticeDataService getNoticeDataService = RetrofitInstance.getApiService();

        Call<PeopleModel> peopleModelCall = getNoticeDataService.getPaggingData(page);

        peopleModelCall.enqueue(new Callback<PeopleModel>() {
            @Override
            public void onResponse(Call<PeopleModel> call, Response<PeopleModel> response) {
                onFinishedListener.onFinished(response.body().getResults(),response.body());
            }

            @Override
            public void onFailure(Call<PeopleModel> call, Throwable t) {

            }
        });
    }
}
