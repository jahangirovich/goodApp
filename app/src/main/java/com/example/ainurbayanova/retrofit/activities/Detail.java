package com.example.ainurbayanova.retrofit.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.ainurbayanova.retrofit.R;
import com.example.ainurbayanova.retrofit.adapter.PacksAdapter;
import com.example.ainurbayanova.retrofit.mvp.model.Categories;
import com.example.ainurbayanova.retrofit.mvp.model.FilmsModel;
import com.example.ainurbayanova.retrofit.mvp.model.Packs;
import com.example.ainurbayanova.retrofit.mvp.model.ResultModel;
import com.example.ainurbayanova.retrofit.mvp.presenter.DetailMainPresenter;
import com.example.ainurbayanova.retrofit.mvp.presenter.GetNoticePresenter;
import com.example.ainurbayanova.retrofit.mvp.presenter.MainFilmsPresenter;
import com.example.ainurbayanova.retrofit.mvp.view.interfaces.interfaces.GetFilmsInterface;
import com.example.ainurbayanova.retrofit.mvp.view.interfaces.interfaces.PeopleDetailInterface;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Detail extends AppCompatActivity {
    int id = 0;
    TextView name;
    Categories categories;
    PacksAdapter packsAdapter;
    RecyclerView recyclerView;
    ArrayList<Packs> packs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        initWidgets();
        initBundle();
        setWidgetsValue();
        initRecycler();
    }
    public void initBundle(){
        Bundle bundle = getIntent().getExtras();
        if(bundle != null){
            categories = (Categories) bundle.getSerializable("categories");
        }
    }

    public void initWidgets(){
        name = findViewById(R.id.name);
        recyclerView = findViewById(R.id.recyclerView);
        packs = new ArrayList<>();
        packsAdapter = new PacksAdapter(packs);
    }

    public void setWidgetsValue(){
        name.setText(categories.getTitle());
    }

    public void initRecycler(){
        packs.addAll(categories.getPacksList());
        packsAdapter.notifyDataSetChanged();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(packsAdapter);
    }
}
