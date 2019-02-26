package com.example.ainurbayanova.retrofit.mvp.view.interfaces.interfaces;

import com.example.ainurbayanova.retrofit.mvp.model.FilmsModel;
import com.example.ainurbayanova.retrofit.mvp.model.ResultModel;

import java.util.ArrayList;

public interface GetFilmsInterface  {
    interface Model{
        interface onFinishedListener{
            void onFinished(FilmsModel resultModel);
        }
        void getDetailOfFilms(Model.onFinishedListener onFinishedListener, int id);
    }

    interface Presenter{
        void getRequestOfData(int id);
    }

    interface View{
        void showProgress();
        void hideProgress();
        void setDatas(FilmsModel resultModel);
    }
}
