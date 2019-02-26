package com.example.ainurbayanova.retrofit.mvp.presenter;

import android.util.Log;

import com.example.ainurbayanova.retrofit.mvp.model.Categories;
import com.example.ainurbayanova.retrofit.mvp.model.MainCategory;
import com.example.ainurbayanova.retrofit.mvp.network.RetrofitInstance;
import com.example.ainurbayanova.retrofit.mvp.view.interfaces.interfaces.ForCategoriesInterface;
import com.example.ainurbayanova.retrofit.mvp.view.interfaces.interfaces.GetNoticeDataService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GetCategoriesPresenter implements ForCategoriesInterface.Model{

    @Override
    public void getNextOfFinished(final onFinishedListener onFinishedListener) {
        final GetNoticeDataService getNoticeDataService = RetrofitInstance.getApiService();
        Call<MainCategory> resultModelCall = getNoticeDataService.getPeopleModel();

        resultModelCall.enqueue(new Callback<MainCategory>() {
            @Override
            public void onResponse(Call<MainCategory> call, Response<MainCategory> response) {
                onFinishedListener.onFinished(response.body());
            }

            @Override
            public void onFailure(Call<MainCategory> call, Throwable t) {
                Log.e("Error get cate", t.getMessage());
            }
        });
    }
}
