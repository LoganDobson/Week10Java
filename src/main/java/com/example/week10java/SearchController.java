package com.example.week10java;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ResourceBundle;

public class SearchController implements Initializable {

    @FXML
    private ImageView imageView;

    @FXML
    private ListView<Movie> listView;

    @FXML
    private TextField searchTextField;

    @FXML
    void showMovies(ActionEvent event) {
        listView.getItems().clear();
        String searchText = searchTextField.getText();
        ApiResponse apiResponse = ApiUtility.getDataFromApiQuick(searchText);
        listView.getItems().addAll(apiResponse.getSearch());

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        listView.getSelectionModel().selectedItemProperty().addListener((observableValue, oldMovie, newMovie) ->{
            try {
                imageView.setImage(new Image(newMovie.getPoster()));
            }catch (Exception e){
                imageView.setImage(new Image("https://www.salonlfc.com/wp-content/uploads/2018/01/image-not-found-scaled.png"));
            }

        } );

    }
}

