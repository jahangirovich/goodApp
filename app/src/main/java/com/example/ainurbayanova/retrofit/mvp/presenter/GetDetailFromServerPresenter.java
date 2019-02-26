package com.example.ainurbayanova.retrofit.mvp.presenter;


import com.example.ainurbayanova.retrofit.mvp.model.ResultModel;
import com.example.ainurbayanova.retrofit.mvp.network.RetrofitInstance;
import com.example.ainurbayanova.retrofit.mvp.view.interfaces.interfaces.GetNoticeDataService;
import com.example.ainurbayanova.retrofit.mvp.view.interfaces.interfaces.PeopleDetailInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GetDetailFromServerPresenter implements PeopleDetailInterface.Model {

    @Override
    public void getDetailOResult(final onFinishedListener onFinishedListener, int id) {
        final GetNoticeDataService getNoticeDataService = RetrofitInstance.getApiService();
        Call<ResultModel> resultModelCall = getNoticeDataService.getPeopleDetailMode(id);

        resultModelCall.enqueue(new Callback<ResultModel>() {
            @Override
            public void onResponse(Call<ResultModel> call, Response<ResultModel> response) {
                onFinishedListener.onFinished(response.body());
            }

            @Override
            public void onFailure(Call<ResultModel> call, Throwable t) {

            }
        });
    }

}
