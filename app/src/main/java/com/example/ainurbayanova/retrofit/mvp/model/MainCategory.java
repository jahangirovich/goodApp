package com.example.ainurbayanova.retrofit.mvp.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MainCategory implements Serializable {
    @SerializedName("data")
    List<Categories> categories = new ArrayList<>();

    public List<Categories> getCategories() {
        return categories;
    }

    public void setCategories(List<Categories> categories) {
        this.categories = categories;
    }
}
