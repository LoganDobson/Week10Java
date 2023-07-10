package com.example.week10java;

import com.google.gson.annotations.SerializedName;
import javafx.fxml.FXML;

public class Movie {
    @SerializedName("Title")
    private String title;
    @SerializedName("Year")
    private String year;

    private String imdbId;
    @SerializedName("Type")
    private String type;
    @SerializedName("Poster")
    private String poster;

    public String getTitle() {
        return title;
    }

    public String getYear() {
        return year;
    }

    public String getImdbId() {
        return imdbId;
    }

    public String getType() {
        return type;
    }

    public String getPoster() {
        return poster;
    }
}
