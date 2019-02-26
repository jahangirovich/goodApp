package com.example.ainurbayanova.retrofit.mvp.view.interfaces.interfaces;

import com.example.ainurbayanova.retrofit.mvp.model.Categories;
import com.example.ainurbayanova.retrofit.mvp.model.MainCategory;

import java.util.ArrayList;

public interface ForCategoriesInterface {
    interface Model{
        interface onFinishedListener{
            void onFinished(MainCategory mainCategory);
        }
        void getNextOfFinished(onFinishedListener onFinishedListener);
    }
    interface Presenter{
        void setRequestToServer();
    }
    interface View{
        void showProgress();
        void hideProgress();
        void setToRecyclerView(MainCategory mainCategory);
    }
}
