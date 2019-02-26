package com.example.ainurbayanova.retrofit.mvp.presenter;

import com.example.ainurbayanova.retrofit.mvp.model.ResultModel;
import com.example.ainurbayanova.retrofit.mvp.view.interfaces.interfaces.PeopleDetailInterface;

public class DetailMainPresenter implements PeopleDetailInterface.Presenter,PeopleDetailInterface.Model.onFinishedListener {
    public PeopleDetailInterface.Model model;
    public PeopleDetailInterface.View view;

    public DetailMainPresenter(PeopleDetailInterface.View view){
        this.view = view;
        this.model = new GetDetailFromServerPresenter();
    }

    @Override
    public void getRequestOfData(int id) {
        if(view != null){
            view.showProgress();
        }
        model.getDetailOResult(this,id);
    }

    @Override
    public void onFinished(ResultModel resultModel) {
        if(view != null){
            view.hideProgress();
            view.setDatas(resultModel);
        }
    }
}
