package com.example.week10java;

import com.google.gson.annotations.SerializedName;

public class ApiResponse {
    @SerializedName("Search")
    private Movie[] search;
    private String totalResults;
    @SerializedName("Response")
    private String response;

    public Movie[] getSearch() {
        return search;
    }

    public String getTotalResults() {
        return totalResults;
    }

    public String getResponse() {
        return response;
    }
}
