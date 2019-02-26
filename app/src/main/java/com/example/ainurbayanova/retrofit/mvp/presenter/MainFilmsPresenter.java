package com.example.ainurbayanova.retrofit.mvp.presenter;

import com.example.ainurbayanova.retrofit.mvp.model.FilmsModel;
import com.example.ainurbayanova.retrofit.mvp.view.interfaces.interfaces.GetFilmsInterface;

public class MainFilmsPresenter implements GetFilmsInterface.Model.onFinishedListener,GetFilmsInterface.Presenter{
    GetFilmsInterface.Model model;
    GetFilmsInterface.View view;

    public MainFilmsPresenter(GetFilmsInterface.View view){
        this.view = view;
        model = new GetFilmsPresenter();
    }

    @Override
    public void onFinished(FilmsModel resultModel) {
        if(view != null){
            view.hideProgress();
            view.setDatas(resultModel);
        }
    }

    @Override
    public void getRequestOfData(int id) {
        if(view != null){
            view.showProgress();
        }
        model.getDetailOfFilms(this,id);
    }
}
