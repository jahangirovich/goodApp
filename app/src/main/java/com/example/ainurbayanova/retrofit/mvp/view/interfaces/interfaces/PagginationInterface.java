package com.example.ainurbayanova.retrofit.mvp.view.interfaces.interfaces;

import com.example.ainurbayanova.retrofit.mvp.model.PeopleModel;
import com.example.ainurbayanova.retrofit.mvp.model.ResultModel;

import java.util.ArrayList;

public interface PagginationInterface {
    interface Model{
        interface OnFinishedListener{
            void onFinished(ArrayList<ResultModel> resultModels,PeopleModel peopleModel);
        }
        void getAllFinished(OnFinishedListener onFinishedListener,int page);
    }
    interface Presenter{
        void requestPaggingFromServer(int page);
    }
    interface View{
        void hidePagginationProgress();
        void showPagginationProgress();
        void addDatas(ArrayList<ResultModel> resultModels, PeopleModel peopleModel);
    }
}