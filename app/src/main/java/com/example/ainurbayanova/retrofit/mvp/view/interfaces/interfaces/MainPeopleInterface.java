package com.example.ainurbayanova.retrofit.mvp.view.interfaces.interfaces;

import com.example.ainurbayanova.retrofit.mvp.model.PeopleModel;
import com.example.ainurbayanova.retrofit.mvp.model.ResultModel;

import java.util.ArrayList;

public interface MainPeopleInterface {
    interface Presenter{
        void onRefreshButtonClick();
        void requestDataFromServer();
    }
    interface MainView{
        void showProgress();
        void hideProgress();
        void setDataToRecyclerView(ArrayList<ResultModel> peoples,PeopleModel peopleModel);
    }
    interface getNoticeIntractor{
        interface OnFinishedListener{
            void onFinished(ArrayList<ResultModel> peoples,PeopleModel peopleModel);
        }
        void getNoticeArrayList(OnFinishedListener listener);
    }
}
