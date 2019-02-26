package com.example.ainurbayanova.retrofit.mvp.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Categories implements Serializable{
    @SerializedName("id")
    int id;

    @SerializedName("title")
    String title;

    @SerializedName("icon")
    String icon;

    @SerializedName("packs")
    List<Packs> packsList = new ArrayList<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public List<Packs> getPacksList() {
        return packsList;
    }

    public void setPacksList(List<Packs> packsList) {
        this.packsList = packsList;
    }
}
