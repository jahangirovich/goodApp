package com.example.ainurbayanova.retrofit.mvp.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ResultModel implements Serializable {
    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("height")
    @Expose
    private String height;

    @SerializedName("mass")
    @Expose
    private String mass;

    @SerializedName("hair_color")
    @Expose
    private String hair_color;

    @SerializedName("eye_color")
    @Expose
    private String eye_color;

    @SerializedName("birth_year")
    @Expose
    private String birth_year;

    @SerializedName("gender")
    @Expose
    private String gender;

    @SerializedName("url")
    @Expose
    private String url;

    @SerializedName("films")
    @Expose
    private List<String> filmsModels;

    public List<String> getFilmsModels() {
        return filmsModels;
    }

    public String getName() {
        return name;
    }

    public String getHeight() {
        return height;
    }

    public String getMass() {
        return mass;
    }

    public String getHair_color() {
        return hair_color;
    }

    public String getEye_color() {
        return eye_color;
    }

    public String getBirth_year() {
        return birth_year;
    }

    public String getGender() {
        return gender;
    }

    public String getUrl() {
        return url;
    }
}
