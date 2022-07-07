package com.parthib.newshub;

import java.util.ArrayList;

public class MainNews {

    private String totalResults;
    private String status;
    private ArrayList<ModelClass>articles;

    public MainNews(String totalResults, String status, ArrayList<ModelClass> articles) {
        this.totalResults = totalResults;
        this.status = status;
        this.articles = articles;
    }

    public String getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(String totalResults) {
        this.totalResults = totalResults;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ArrayList<ModelClass> getArticles() {
        return articles;
    }

    public void setArticles(ArrayList<ModelClass> articles) {
        this.articles = articles;
    }
}
