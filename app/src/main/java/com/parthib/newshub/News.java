package com.parthib.newshub;

import java.util.ArrayList;

public class News {

    private String status;
    private String totalResults;
    private ArrayList<ModelClass>articles;

    public News(String status, String totalResults, ArrayList<ModelClass> articles) {
        this.status = status;
        this.totalResults = totalResults;
        this.articles = articles;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(String totalResults) {
        this.totalResults = totalResults;
    }

    public ArrayList<ModelClass> getArticles() {
        return articles;
    }

    public void setArticles(ArrayList<ModelClass> articles) {
        this.articles = articles;
    }
}
