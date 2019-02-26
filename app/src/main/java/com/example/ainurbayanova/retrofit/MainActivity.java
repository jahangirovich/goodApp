package com.example.ainurbayanova.retrofit;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ProgressBar;

import com.example.ainurbayanova.retrofit.activities.Detail;
import com.example.ainurbayanova.retrofit.adapter.PeoplesAdapter;
import com.example.ainurbayanova.retrofit.mvp.model.PeopleModel;
import com.example.ainurbayanova.retrofit.mvp.model.ResultModel;
import com.example.ainurbayanova.retrofit.mvp.presenter.GetNoticePresenter;
import com.example.ainurbayanova.retrofit.mvp.presenter.MainPeoplePresenter;
import com.example.ainurbayanova.retrofit.mvp.view.interfaces.interfaces.ClickItemInterface;
import com.example.ainurbayanova.retrofit.mvp.view.interfaces.interfaces.MainPeopleInterface;
import com.example.ainurbayanova.retrofit.mvp.view.interfaces.interfaces.PagginationInterface;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements MainPeopleInterface.MainView ,PagginationInterface.View{
    RecyclerView recyclerView;
    ProgressBar progressBar;
    PeoplesAdapter adapter;
    MainPeoplePresenter presenter;
    ArrayList<ResultModel> peopleModels = new ArrayList<>();
    boolean first = true;
    ProgressDialog progressDialog;
    ProgressBar pagginationProgressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initWidgets();
        initRecycler();

        presenter = new MainPeoplePresenter(this, new GetNoticePresenter());
        presenter.requestDataFromServer();
    }

    private void initWidgets() {
        recyclerView = findViewById(R.id.recyclerView);
        pagginationProgressBar = findViewById(R.id.progressBarForPaggination);
        progressBar = findViewById(R.id.progressBar);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
        recyclerView.setLayoutManager(layoutManager);
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
    public void setDataToRecyclerView(ArrayList<ResultModel> peoples, PeopleModel peopleModel) {
        peopleModels.addAll(peoples);
        adapter.notifyDataSetChanged();
        scrollRecyclerView(peopleModel);
        clickThem(peopleModels);
    }

    public void scrollRecyclerView(final PeopleModel peopleModel){
        recyclerView.setOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                LinearLayoutManager linearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
                if (linearLayoutManager != null && linearLayoutManager.findLastCompletelyVisibleItemPosition() == peopleModels.size() - 1) {
                    String[] shares = peopleModel.getNext().split("=");
                    initPaggination(Integer.parseInt(shares[shares.length - 1]));
                    showPagginationProgress();
                }
            }
        });
//        clickThem(peoples);
    }

    public void initRecycler(){
        adapter = new PeoplesAdapter(peopleModels);
        recyclerView.setAdapter(adapter);
    }

    public void initPaggination(int page) {
        presenter.setPaggination(this);
        presenter.requestPaggingFromServer(page);
    }

    public void clickThem(final ArrayList<ResultModel> resultModel) {
        adapter.setClickListener(new ClickItemInterface() {
            @Override
            public void onClick(int position) {
                Intent intent = new Intent(MainActivity.this, Detail.class);
                intent.putExtra("id", peopleModels.get(position).getUrl());
                startActivity(intent);
            }
        });
    }

    @Override
    public void hidePagginationProgress() {
        pagginationProgressBar.setVisibility(View.GONE);
    }

    @Override
    public void showPagginationProgress() {
        pagginationProgressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void addDatas(ArrayList<ResultModel> resultModels, PeopleModel peopleModel) {
        peopleModels.addAll(resultModels);
        adapter.notifyDataSetChanged();
    }
}
