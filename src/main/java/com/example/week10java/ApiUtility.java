package com.example.week10java;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import java.io.FileReader;

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
}
