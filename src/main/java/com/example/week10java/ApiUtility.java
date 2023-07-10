package com.example.week10java;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import java.io.FileReader;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ApiUtility {
    public static ApiResponse getDataFromFile(String fileName){
        ApiResponse apiResponse = null;
        Gson gson = new Gson();

        try(
                FileReader fileReader = new FileReader(fileName);
                JsonReader jsonReader = new JsonReader(fileReader)
                ) {
            apiResponse = gson.fromJson(jsonReader,ApiResponse.class);

        }catch (Exception e){
            e.printStackTrace();
        }
        return apiResponse;
    }

    //http requests in this bitch

    public static ApiResponse getDataFromApi(String searchName){
        searchName = searchName.replace(" ", "%20");
        String url = "https://www.omdbapi.com/?apikey=a32ce9e8&s=" + searchName;

        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest httpRequest = HttpRequest.newBuilder().uri(URI.create(url)).build();

        try {
            HttpResponse<Path> response = httpClient.send(httpRequest, HttpResponse
                    .BodyHandlers
                    .ofFile(Paths.get("javaApiFetched.json")));
        } catch (Exception e){
            e.printStackTrace();
        }

        return ApiUtility.getDataFromFile("javaApiFetched.json");
    }

    //fuck that file

    public static ApiResponse getDataFromApiQuick(String searchName){
        searchName = searchName.replace(" ", "%20");
        String url = "https://www.omdbapi.com/?apikey=a32ce9e8&s=" + searchName;

        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest httpRequest = HttpRequest.newBuilder().uri(URI.create(url)).build();

        try {
            HttpResponse<String> response = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
            Gson gson = new Gson();
            return gson.fromJson(response.body(), ApiResponse.class);
        } catch (Exception e){
            e.printStackTrace();
        }

        return null;
    }

    }

