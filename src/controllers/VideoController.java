package controllers;

import javafx.fxml.Initializable;
import modules.Video;

import java.net.URL;
import java.util.ResourceBundle;

public class VideoController implements Initializable {

    private Video videoModule;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Video videoModule = new Video();
    }
}
