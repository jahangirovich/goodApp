package com.example.ainurbayanova.retrofit.mvp.presenter;

import com.example.ainurbayanova.retrofit.mvp.model.PeopleModel;
import com.example.ainurbayanova.retrofit.mvp.model.ResultModel;
import com.example.ainurbayanova.retrofit.mvp.view.interfaces.interfaces.MainPeopleInterface;
import com.example.ainurbayanova.retrofit.mvp.view.interfaces.interfaces.PagginationInterface;

import java.util.ArrayList;

public class MainPeoplePresenter implements MainPeopleInterface.Presenter,MainPeopleInterface.getNoticeIntractor.OnFinishedListener,PagginationInterface.Presenter,PagginationInterface.Model.OnFinishedListener{
    private MainPeopleInterface.MainView mainView;
    private MainPeopleInterface.getNoticeIntractor getNoticeIntractor;
    private PagginationInterface.Model model;
    private PagginationInterface.View view;

    public MainPeoplePresenter(MainPeopleInterface.MainView mainView,MainPeopleInterface.getNoticeIntractor getNoticeIntractor){
        this.mainView = mainView;
        this.getNoticeIntractor = getNoticeIntractor;
    }

    @Override
    public void onRefreshButtonClick() {
        if(mainView != null){
            mainView.showProgress();
        }
        getNoticeIntractor.getNoticeArrayList(this);
    }

    public void setPaggination(PagginationInterface.View view){
        this.view = view;
        model = new GetPaggingFromServerPresenter();
    }

    @Override
    public void requestDataFromServer() {
        getNoticeIntractor.getNoticeArrayList(this);
    }

    @Override
    public void onFinished(ArrayList<ResultModel> peoples, PeopleModel peopleModel) {
        if(mainView != null){
            mainView.setDataToRecyclerView(peoples,peopleModel);
            mainView.hideProgress();
        }
        if(view != null){
            view.addDatas(peoples,peopleModel);
            view.hidePagginationProgress();
        }
    }

    @Override
    public void requestPaggingFromServer(int page) {
        model.getAllFinished(this,page);
    }
}
