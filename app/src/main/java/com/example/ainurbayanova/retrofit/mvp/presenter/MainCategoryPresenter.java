package com.example.ainurbayanova.retrofit.mvp.presenter;

import com.example.ainurbayanova.retrofit.mvp.model.MainCategory;
import com.example.ainurbayanova.retrofit.mvp.view.interfaces.interfaces.ForCategoriesInterface;

public class MainCategoryPresenter implements ForCategoriesInterface.Presenter ,ForCategoriesInterface.Model.onFinishedListener{
    ForCategoriesInterface.View view;
    ForCategoriesInterface.Model model;

    public MainCategoryPresenter(ForCategoriesInterface.View view){
        this.view = view;
        model = new GetCategoriesPresenter();
    }

    @Override
    public void onFinished(MainCategory mainCategory) {
        if(view != null){
            view.hideProgress();
            view.setToRecyclerView(mainCategory);
        }
    }

    @Override
    public void setRequestToServer() {
        if(view != null){
            view.showProgress();
        }
        model.getNextOfFinished(this);
    }
}
