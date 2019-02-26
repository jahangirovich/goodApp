package com.example.ainurbayanova.retrofit.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import com.example.ainurbayanova.retrofit.R;
import com.example.ainurbayanova.retrofit.adapter.CategoriesAdapter;
import com.example.ainurbayanova.retrofit.mvp.model.Categories;
import com.example.ainurbayanova.retrofit.mvp.model.Login;
import com.example.ainurbayanova.retrofit.mvp.model.MainCategory;
import com.example.ainurbayanova.retrofit.mvp.model.ResultModel;
import com.example.ainurbayanova.retrofit.mvp.model.User;
import com.example.ainurbayanova.retrofit.mvp.network.RetrofitInstance;
import com.example.ainurbayanova.retrofit.mvp.presenter.MainCategoryPresenter;
import com.example.ainurbayanova.retrofit.mvp.view.interfaces.interfaces.ClickItemInterface;
import com.example.ainurbayanova.retrofit.mvp.view.interfaces.interfaces.ForCategoriesInterface;
import com.example.ainurbayanova.retrofit.mvp.view.interfaces.interfaces.GetNoticeDataService;
import com.example.ainurbayanova.retrofit.mvp.view.interfaces.interfaces.GetRetrofitDataService;

import java.util.ArrayList;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity implements ForCategoriesInterface.View{
//    GetNoticeDataService getLogin = (GetNoticeDataService) RetrofitInstance.postApiService();

    Button button;
    MainCategoryPresenter mainCategoryPresenter;
    RecyclerView recyclerView;
    ArrayList<Categories> categoriesArrayList = new ArrayList<>();
    CategoriesAdapter categoriesAdapter;
    ProgressBar progressBar;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_layout);
        initWidgets();
        initRecycler();
        clickListeners();
    }
    public void initWidgets(){
        button = findViewById(R.id.authenticate);
        mainCategoryPresenter = new MainCategoryPresenter(this);
        recyclerView = findViewById(R.id.recyclerView);
        progressBar = findViewById(R.id.progressBar);
        categoriesAdapter = new CategoriesAdapter(categoriesArrayList);
    }

    public void clickListeners(){
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });
        categoriesAdapter.setClickListener(new ClickItemInterface() {
            @Override
            public void onClick(int position) {
                Intent intent = new Intent(LoginActivity.this,Detail.class);
                intent.putExtra("categories",categoriesArrayList.get(position));
                startActivity(intent);
            }
        });
    }

    public void initRecycler(){
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(categoriesAdapter);
    }

    public void login(){
        categoriesArrayList.clear();
        mainCategoryPresenter.setRequestToServer();
    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void setToRecyclerView(MainCategory mainCategory) {
        categoriesArrayList.addAll(mainCategory.getCategories());
        categoriesAdapter.notifyDataSetChanged();
    }
}
