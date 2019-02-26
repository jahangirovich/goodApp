package com.example.ainurbayanova.retrofit.mvp.presenter;

import com.example.ainurbayanova.retrofit.mvp.model.FilmsModel;
import com.example.ainurbayanova.retrofit.mvp.model.PeopleModel;
import com.example.ainurbayanova.retrofit.mvp.network.RetrofitInstance;
import com.example.ainurbayanova.retrofit.mvp.view.interfaces.interfaces.GetFilmsInterface;
import com.example.ainurbayanova.retrofit.mvp.view.interfaces.interfaces.GetNoticeDataService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GetFilmsPresenter implements GetFilmsInterface.Model{

    @Override
    public void getDetailOfFilms(final onFinishedListener onFinishedListener, int id) {
        final GetNoticeDataService getNoticeDataService = RetrofitInstance.getApiService();

        Call<FilmsModel> call = getNoticeDataService.getFilms(id);

        call.enqueue(new Callback<FilmsModel>() {
            @Override
            public void onResponse(Call<FilmsModel> call, Response<FilmsModel> response) {
                onFinishedListener.onFinished(response.body());
            }

            @Override
            public void onFailure(Call<FilmsModel> call, Throwable t) {

            }
        });
    }
}
