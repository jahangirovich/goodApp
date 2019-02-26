package com.example.ainurbayanova.retrofit.mvp.view.interfaces.interfaces;

import com.example.ainurbayanova.retrofit.mvp.model.ResultModel;

public interface PeopleDetailInterface {
    interface Model{
        interface onFinishedListener{
            void onFinished(ResultModel resultModel);
        }
        void getDetailOResult(onFinishedListener onFinishedListener,int id);
    }

    interface Presenter{
        void getRequestOfData(int id);
    }

    interface View{
        void showProgress();
        void hideProgress();
        void setDatas(ResultModel resultModel);
    }
}
