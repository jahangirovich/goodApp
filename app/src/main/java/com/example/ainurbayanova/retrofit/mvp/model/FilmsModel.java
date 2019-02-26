package com.example.ainurbayanova.retrofit.mvp.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class FilmsModel implements Serializable {
    @SerializedName("title")
    @Expose
    String title;
    @SerializedName("opening_crawl")
    @Expose
    String opening_crawl;
    @SerializedName("director")
    @Expose
    String director;
    @SerializedName("producer")
    @Expose
    String producer;
    @SerializedName("realise_date")
    @Expose
    String realise_date;

    public FilmsModel(String title, String opening_crawl, String director, String producer, String realise_date) {
        this.title = title;
        this.opening_crawl = opening_crawl;
        this.director = director;
        this.producer = producer;
        this.realise_date = realise_date;
    }

    public String getTitle() {
        return title;
    }

    public String getOpening_crawl() {
        return opening_crawl;
    }

    public String getDirector() {
        return director;
    }

    public String getProducer() {
        return producer;
    }

    public String getRealise_date() {
        return realise_date;
    }
}
