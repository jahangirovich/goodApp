package com.example.ainurbayanova.retrofit.mvp.presenter;

import com.example.ainurbayanova.retrofit.mvp.model.PeopleModel;
import com.example.ainurbayanova.retrofit.mvp.model.ResultModel;
import com.example.ainurbayanova.retrofit.mvp.view.interfaces.interfaces.PagginationInterface;

import java.util.ArrayList;

public class PagginationMainPresenter implements PagginationInterface.Presenter,PagginationInterface.Model.OnFinishedListener {
    PagginationInterface.View view;
    PagginationInterface.Model model;

    public PagginationMainPresenter(PagginationInterface.View view){
        this.view = view;
        model = new GetPaggingFromServerPresenter();
    }

    public void setPaggination(PagginationInterface.View view){

    }

    @Override
    public void requestPaggingFromServer(int page) {
        if(view != null){
            view.showPagginationProgress();
        }
        model.getAllFinished(this,page);
    }

    @Override
    public void onFinished(ArrayList<ResultModel> resultModels, PeopleModel peopleModel) {
        if(view !=null){
            view.addDatas(resultModels,peopleModel);
            view.hidePagginationProgress();
        }
    }
}
